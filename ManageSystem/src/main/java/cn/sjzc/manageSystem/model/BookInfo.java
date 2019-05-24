package cn.sjzc.manageSystem.model;

import java.math.BigDecimal;
import java.util.Date;

public class BookInfo {
    private int bookId;

    private String name;

    private String author;

    private String publish;

    private String picture;

    private BigDecimal price;

    private Date pubDate;

    private Integer classId1;

    private String introduction;

    private String isbn;
    
    private int maxNumber;
    
    private int realNumber;
    
    private int borrowTimes;
    
    private String location;
    
    private Date createtime;
    
    private Integer classId2;
    
    private Integer classId3;
    
    
	public Integer getClassId1() {
		return classId1;
	}

	public void setClassId1(Integer classId1) {
		this.classId1 = classId1;
	}

	public Integer getClassId2() {
		return classId2;
	}

	public void setClassId2(Integer classId2) {
		this.classId2 = classId2;
	}

	public Integer getClassId3() {
		return classId3;
	}

	public void setClassId3(Integer classId3) {
		this.classId3 = classId3;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	public int getRealNumber() {
		return realNumber;
	}

	public void setRealNumber(int realNumber) {
		this.realNumber = realNumber;
	}

	public int getBorrowTimes() {
		return borrowTimes;
	}

	public void setBorrowTimes(int borrowTimes) {
		this.borrowTimes = borrowTimes;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish == null ? null : publish.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}