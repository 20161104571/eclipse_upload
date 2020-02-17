package com.imnu.SchoolBus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.imnu.SchoolBus.pojo.Notice;

@Mapper
public interface NoticeMapper {
	
	@Insert(value = "insert into notice (nId,title,releaseTime,noticeText,author) values (#{nId},#{title},#{releaseTime},#{noticeText},#{author})")
	void createNotice(Notice notice);
	
	@Delete(value = "delete from notice where nId = #{nId}")
	int deleteNotice(Integer nId);
	
	@Select(value = "select * from notice")
	List<Notice> getNoticeList();
	
	@Update(value = "update notice set title = #{title},releaseTime = #{releaseTime},noticeText = #{noticeText},author = #{author} where nId = #{nId}")
	void updateNotice(Notice notice);
	
	@Select(value = "select * from notice where nId = #{nId}")
	Notice findNoticeById(int nId);
}
