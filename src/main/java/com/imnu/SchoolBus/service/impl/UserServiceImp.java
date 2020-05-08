package com.imnu.SchoolBus.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.imnu.SchoolBus.mapper.CommentMapper;
import com.imnu.SchoolBus.mapper.SubsMapper;
import com.imnu.SchoolBus.mapper.UserMapper;
import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.service.MailService;
import com.imnu.SchoolBus.service.UserService;
import com.imnu.SchoolBus.transcation.MyException;

@Service
@Transactional
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private SubsMapper subsMapper;
	
	@Autowired
	private MailService mailService;
	
    @Override
    public void register(User user) {
    	userMapper.register(user);
    	String code = user.getCode();
        System.out.println("code:"+code);
        String email = user.getEmail();
        System.out.println("email:"+email);
        String subject = "注册激活账号邮件";
        String context = "<a href=\"http://localhost:8080/schoolbus/checkCode?code="+code+"\">http://localhost:8080/schoolbus/checkCode?code="+code+"</a>";
        mailService.sendHtmlMail (user.getEmail(),subject,context);
    }

    @Override
    public User checkCode(String code) {
        return userMapper.checkCode(code);
    }

    @Override
    public void updateUserStatus(User user) {
    	userMapper.updateUserStatus(user);
    }

    @Override
    public User loginUser(User user) {
        User user1 = userMapper.loginUser(user);
        if (user1 !=null){
            return user1;
        }
        return null;
    }

	@Override
	public int deleteUser(Integer id) {
		return userMapper.deleteUser(id);
	}

	@Override
	public List<User> getUserList() {
		List<User> list = userMapper.getUserList();
		return list;
	}

	@Override
	public User findUserById(int id) {
		return userMapper.findUserById(id);
	}

	@Override
	public void createUser(User user) {
		userMapper.createUser(user);
	}

	@Override
	public User adminLogin(String username, String password) {
		User u = userMapper.adminLogin(username, password);
		if(u != null) {
			return u;
		}
		return null;
	}

	@Override
	public int changePwd(int id, String newpassword) {
		User user = new User();
		user = userMapper.findUserById(id);
		user.setPassword(newpassword);
		int result = userMapper.changePwd(id, newpassword);
		return result;
	}

	@Override
	public User updateMsg(int id, String username, String name, String email, String phone) {
		User user = new User();
		user = userMapper.findUserById(id);
		user.setUsername(username);
		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);
		int result = userMapper.updateMsg(id, username, name, email, phone);
		if(result > 0) {
			return user;
		}else {
			return null;
		}
	}

	@Override
	public int countUser(Integer count) {
		int c = userMapper.countUser(count);
		if(c>0) {
			return c;
		}
		return 0;
	}
	
	@Override
	public int countTeUser(Integer counts) {
		int tea = userMapper.countTeUser(counts);
		if(tea>0) {
			return tea;
		}
		return 0;
	}

	@Override
	public int countComment(Integer comm) {
		int com = commentMapper.countComment(comm);
		if(com>0) {
			return com;
		}
		return 0;
	}
	
	@Override
	public int countNewOrder(Integer subs) {
		int newor = subsMapper.countNewOrder(subs);
		if(newor>0) {
			return newor;
		}
		return 0;
	}

	@Override
	public List<User> getTeacherList() {
		List<User> list = userMapper.getTeacherList();
		return list;
	}

	@Override
	public boolean findUserByUsername(String username) {
		List<User> list = userMapper.findUserByUsername(username);
		return list.size()==0?false:true;
	}
	
	@Override
	public boolean findStuByNumber(String number) {
		List<User> list = userMapper.findStuByNumber(number);
		return list.size()==0?false:true;
	}

	@Override
	public boolean findUserByPhone(String phone) {
		List<User> list = userMapper.findUserByPhone(phone);
		return list.size()==0?false:true;
	}

	@Override
	public boolean findUserByEmail(String email) {
		List<User> list = userMapper.findUserByEmail(email);
		return list.size()==0?false:true;
	}

	@Override
	public boolean findStuByNameAndNum(String stuname, String stunum) {
		List<User> list = userMapper.findStuByNameAndNum(stuname, stunum);
		return list.size()==0?false:true;
	}

	@Override
	public boolean findUserPwd(int id, String password) {
		List<User> list = userMapper.findUserPwd(id,password);
		return list.size()==0?false:true;
	}
	
	@Override
	public boolean checkUser(User user) {
		List<User> list = userMapper.checkUser(user);
		return list.size()==0?false:true;
	}

	@SuppressWarnings({ "deprecation", "resource" })
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	@Override
	public boolean batchImport(String fileName, MultipartFile file) throws Exception {
		boolean notNull = false;
		List<User> teacherList = new ArrayList<>();
		if(!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
			throw new MyException("上传文件格式不正确");
		}
		boolean isExcel2003 = true;
		if(fileName.matches("^.+\\.(?i)(xlsx)$")) {
			isExcel2003 = false;
		}
		InputStream is = file.getInputStream();
		Workbook wb = null;
		if(isExcel2003) {
			wb = new HSSFWorkbook(is);
		}else {
			wb = new XSSFWorkbook(is);
		}
		Sheet sheet = wb.getSheetAt(0);
		if(sheet != null) {
			notNull = true;
		}
		User user;
		for(int r = 1; r<=sheet.getLastRowNum(); r++) {
			Row row = sheet.getRow(r);
			if(row == null) {
				continue;
			}
			/**
	             * 获取单元格 row.getCell(0)
	             * 设置单元格类型 row.getCell(0).setCellType(CellType.STRING)
	             * 获取单元格数据 String cellValue = row.getCell(0).getStringCellValue();
             */
			user = new User();
			if(row.getCell(0).getCellType() != 1) {
				throw new MyException("导入失败(第"+(r+1)+"行，请设为文本格式)");
			}
			String teachername = row.getCell(0).getStringCellValue();
			if(teachername == null || teachername.isEmpty()) {
				throw new MyException("导入失败(第"+(r+1)+"行，姓名未填写)");
			}
			 row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
			String teachernum = row.getCell(1).getStringCellValue();
			if(teachernum == null || teachernum.isEmpty()) {
				throw new MyException("导入失败(第"+(r+1)+"行，教工号未填写)");
			}
			row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
			String teacherphone = row.getCell(2).getStringCellValue();
			if(teacherphone == null || teacherphone.isEmpty()) {
				throw new MyException("导入失败(第"+(r+1)+"行，电话号码未填写)");
			}
			row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
			String teacheremail = row.getCell(3).getStringCellValue();
			if(teacheremail == null || teacheremail.isEmpty()) {
				throw new MyException("导入失败(第"+(r+1)+"行，邮箱未填写)");
			}
			user.setUsername(teachername);
			user.setPassword("123456");
			user.setName(teachername);
			user.setNumber(teachernum);
			user.setEmail(teacheremail);
			user.setPhone(teacherphone);
			user.setStatus(3);
			teacherList.add(user);
		}
		for(User userResord : teacherList) {
			String number = userResord.getNumber();
			int cnt = userMapper.selectByNumber(number).size();
			if(cnt==0) {
				userMapper.insertTeachersByExcel(userResord);
				System.out.println("插入"+userResord);
			}else {
				userMapper.updateByNum(userResord);
				System.out.println("修改"+userResord);
			}
		}
		
		return notNull;
	}

	
	

		
}
