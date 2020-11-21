package com.EarphoneModels.Entitys;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.EarphoneModels.EnumTypePhone;



@Entity
@Table(name = "earphones")
public class Earphone extends BaseEntity{

  @Column
  @NotNull(message = "wireless is Required")
  private Boolean wireless;

  @Column
  @NotNull(message = "driver is Required")
  private String driver;

  @Enumerated(EnumType.STRING)
  @NotNull(message = "enumTypePhone is Required")
  private EnumTypePhone enumTypePhone;

  public Earphone(String driver, Boolean wireless, EnumTypePhone enumTypePhone, Date releaseAt){
    this.wireless = wireless;
    this.driver = driver;
    this.enumTypePhone = enumTypePhone;
  }

  public Earphone(){
    super();
  }


  public String getDriver() {
    return driver;
  }


  public Boolean getWireless() {
    return wireless;
  }

  public EnumTypePhone getEnumTypePhone() {
    return enumTypePhone;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }
  public void setEnumTypePhone(EnumTypePhone enumTypePhone) {
    this.enumTypePhone = enumTypePhone;
  }

  public void setWireless(Boolean wireless) {
    this.wireless = wireless;
  }


}
