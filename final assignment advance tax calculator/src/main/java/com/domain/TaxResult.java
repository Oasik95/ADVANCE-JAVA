package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "taxresult")
public class TaxResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @NotNull
    @Column(name = "basic_salary")
    private BigDecimal basicsalary;

    @NotNull
    @Column(name = "house_rent")
    private BigDecimal houserent;

    @NotNull
    @Column(name = "conveyance")
    private BigDecimal conveyance;

    @NotNull
    @Column(name = "medical")
    private BigDecimal medical;

    @NotNull
    @Column(name = "others")
    private BigDecimal others;

    @NotNull
    @Column(name = "festival")
    private BigDecimal festival;


    @NotNull
    @Column(name = "total")
    private BigDecimal total;

    @NotNull
    @Column(name = "totalyearlytax")
    private BigDecimal totalyearlytax;

    @NotNull
    @Column(name = "f_year")
    private String fyear;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private TaxUser user;


    public TaxUser getUser() {
        return user;
    }

    public void setUser(TaxUser user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(BigDecimal basicsalary) {
        this.basicsalary = basicsalary;
    }

    public BigDecimal getHouserent() {
        return houserent;
    }

    public void setHouserent(BigDecimal houserent) {
        this.houserent = houserent;
    }

    public BigDecimal getConveyance() {
        return conveyance;
    }

    public void setConveyance(BigDecimal conveyance) {
        this.conveyance = conveyance;
    }

    public BigDecimal getMedical() {
        return medical;
    }

    public void setMedical(BigDecimal medical) {
        this.medical = medical;
    }

    public BigDecimal getOthers() {
        return others;
    }

    public void setOthers(BigDecimal others) {
        this.others = others;
    }

    public BigDecimal getFestival() {
        return festival;
    }

    public void setFestival(BigDecimal festival) {
        this.festival = festival;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalyearlytax() {
        return totalyearlytax;
    }

    public void setTotalyearlytax(BigDecimal totalyearlytax) {
        this.totalyearlytax = totalyearlytax;
    }

    public String getFyear() {
        return fyear;
    }

    public void setFyear(String fyear) {
        this.fyear = fyear;
    }
}
