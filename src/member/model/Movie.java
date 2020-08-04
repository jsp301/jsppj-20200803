package member.model;

import java.util.Date;

public class Movie {
	private Integer number;
	private Writer writer;
	private String title;
	private Date regDate;
	private Date modiDate;
	private int readCount;
	
	public Movie(Integer number, Writer writer, String title, Date regDate, Date modiDate, int readCount) {
		super();
		this.number = number;
		this.writer = writer;
		this.title = title;
		this.regDate = regDate;
		this.modiDate = modiDate;
		this.readCount = readCount;
	}
	
	public Date getModiDate() {
		return modiDate;
	}
	public Integer getNumber() {
		return number;
	}
	public Writer getWriter() {
		return writer;
	}
	public String getTitle() {
		return title;
	}
	public Date getRegDate() {
		return regDate;
	}
	public int getReadCount() {
		return readCount;
	}
}
