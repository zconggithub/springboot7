package com.example.demo.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
/**
 * 
 * @author zhoucong(QQ:2632652610)
 *
 */
@Data
public class Friend {
	
    private Integer fid;
    
    @NotBlank(message="账户不能为空")//@NotBlank(message =)   验证字符串非null，且长度必须大于0 
    @Pattern(regexp="/^[A-Za-z0-9\\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$/",message="账户是允许汉字、字母、数字，域名只允许英文域名")//被注释的元素必须符合指定的正则表达式 
    private String fname;
    
    
    //@Pattern(regexp="^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$", message="身份证格式错误")
/* 由于对应的数据库中无此字段，可作为学习参考  
 *  @NotEmpty(message="密码不能为空")
    @Length(min=6,message="密码长度不能小于6位")
    private String password;*/
   
    private Integer tid;

    private String ftel;

    private String sex;
    
    @Min(value=18,message="不允许未成年录入")
    @Max(value=75,message="年龄超出服务范围")
    private Integer age;
    
    private Integer monthSal;
    
    private Integer annualBonus;
    
    public Friend(){}

	public Friend(Integer fid, String fname, Integer tid, String ftel, String sex, Integer age, Integer monthSal,
			Integer annualBonus) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.tid = tid;
		this.ftel = ftel;
		this.sex = sex;
		this.age = age;
		this.monthSal = monthSal;
		this.annualBonus = annualBonus;
	}

}