package com.service;

import com.domain.Tax;
import com.domain.TaxResult;
import com.repository.TaxRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TaxImplService implements TaxService{

    private TaxRepository taxRepository;





    public TaxImplService(TaxRepository taxRepository ) {
        this.taxRepository = taxRepository;


    }

    @Transactional
    public Tax insert(Tax tax) {

        return taxRepository.create(tax);
    }

    @Transactional
    public TaxResult calculateTax (Tax tax) {
        TaxResult taxResult=new TaxResult();
        taxResult.setFyear(tax.getFyear());
        BigDecimal Yearlybasic=tax.getBasicsalary().multiply(BigDecimal.valueOf(12));
        BigDecimal houserent=tax.getHouserent()
                .multiply(BigDecimal.valueOf(12)).subtract(Yearlybasic.divide(BigDecimal.valueOf(2)));
        BigDecimal other=tax.getOthers().multiply(BigDecimal.valueOf(12));
        BigDecimal conv=tax.getConveyance()
                .multiply(BigDecimal.valueOf(12))
                .subtract(BigDecimal.valueOf(30000));
        BigDecimal fesival=tax.getBasicsalary().multiply(BigDecimal.valueOf(2));
        BigDecimal tot=Yearlybasic.add(houserent)
                .add(other).add(conv).add(fesival);
        BigDecimal result= BigDecimal.valueOf(0.0);
        BigDecimal store=tot;
        houserent=houserent.intValue()<0?BigDecimal.ZERO:houserent;
        conv=conv.intValue()<0?BigDecimal.ZERO:conv;
        if(tax.getCategory().equals("General"))
        {
            if(tax.getZoon().equals("Dhaka"))
            {

                if(tot.intValue()>0)
                {
                  tot=tot.subtract(BigDecimal.valueOf(300000));

                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=100000)
                        result=result.add(BigDecimal.valueOf(5000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.05)));

                    tot=tot.subtract(BigDecimal.valueOf(100000));

                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=300000)
                        result=result.add(BigDecimal.valueOf(30000));

                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.1)));

                    tot=tot.subtract(BigDecimal.valueOf(300000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=400000)
                        result=result.add(BigDecimal.valueOf(60000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.15)));
                    tot=tot.subtract(BigDecimal.valueOf(400000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=500000)
                        result=result.add(BigDecimal.valueOf(100000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.2)));
                    tot=tot.subtract(BigDecimal.valueOf(500000));
                }
                if(tot.intValue()>0)
                {

                    result=result.add(tot.multiply(BigDecimal.valueOf(.25)));
                    tot=BigDecimal.ZERO;
                }
                taxResult.setMedical(BigDecimal.ZERO);
                taxResult.setBasicsalary(Yearlybasic);
                taxResult.setHouserent(houserent);
                taxResult.setConveyance(conv);
                taxResult.setOthers(other);
                taxResult.setFestival(fesival);
                taxResult.setTotal(store);
                taxResult.setTotalyearlytax(result);

            }
            else if(tax.getZoon().equals("Sylhet"))
            {


                if(tot.intValue()>0)
                {

                    tot=tot.subtract(BigDecimal.valueOf(300000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=100000)
                        result=result.add(BigDecimal.valueOf(5000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.02)));

                    tot=tot.subtract(BigDecimal.valueOf(100000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=300000)
                        result=result.add(BigDecimal.valueOf(30000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.04)));
                    tot=tot.subtract(BigDecimal.valueOf(300000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=400000)
                        result=result.add(BigDecimal.valueOf(60000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.06)));
                    tot=tot.subtract(BigDecimal.valueOf(400000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=500000)
                        result=result.add(BigDecimal.valueOf(100000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.10)));
                    tot=tot.subtract(BigDecimal.valueOf(500000));
                }
                if(tot.intValue()>0)
                {

                    result=result.add(tot.multiply(BigDecimal.valueOf(.20)));
                    tot=BigDecimal.ZERO;
                }
                taxResult.setBasicsalary(Yearlybasic);
                taxResult.setHouserent(houserent);
                taxResult.setConveyance(conv);
                taxResult.setOthers(other);
                taxResult.setFestival(fesival);
                taxResult.setTotal(store);
                taxResult.setTotalyearlytax(result);
                taxResult.setMedical(BigDecimal.ZERO);
            }
            else
            {

                if(tot.intValue()>0)
                {

                    tot=tot.subtract(BigDecimal.valueOf(300000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=100000)
                        result=result.add(BigDecimal.valueOf(5000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.04)));

                    tot=tot.subtract(BigDecimal.valueOf(100000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=300000)
                        result=result.add(BigDecimal.valueOf(30000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.08)));
                    tot=tot.subtract(BigDecimal.valueOf(300000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=400000)
                        result=result.add(BigDecimal.valueOf(60000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.12)));
                    tot=tot.subtract(BigDecimal.valueOf(400000));
                }
                if(tot.intValue()>0)

                {
                    if(tot.intValue()>=500000)
                        result=result.add(BigDecimal.valueOf(100000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.15)));
                    tot=tot.subtract(BigDecimal.valueOf(500000));
                }
                if(tot.intValue()>0)
                {

                    result=result.add(tot.multiply(BigDecimal.valueOf(.20)));
                    tot=BigDecimal.ZERO;
                }
                taxResult.setBasicsalary(Yearlybasic);
                taxResult.setHouserent(houserent);
                taxResult.setConveyance(conv);
                taxResult.setOthers(other);
                taxResult.setFestival(fesival);
                taxResult.setTotal(store);
                taxResult.setTotalyearlytax(result);
                taxResult.setMedical(BigDecimal.ZERO);
            }
        }
        else if(tax.getCategory().equals("Female"))
        {
            conv=tax.getConveyance()
                    .multiply(BigDecimal.valueOf(12))
                    .subtract(BigDecimal.valueOf(35000));
            conv=conv.intValue()<0?BigDecimal.ZERO:conv;
            if(tax.getZoon().equals("Dhaka"))
            {

                if(tot.intValue()>0)
                {
                    tot=tot.subtract(BigDecimal.valueOf(300000));

                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=100000)
                        result=result.add(BigDecimal.valueOf(5000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.05)));

                    tot=tot.subtract(BigDecimal.valueOf(100000));

                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=300000)
                        result=result.add(BigDecimal.valueOf(30000));

                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.1)));

                    tot=tot.subtract(BigDecimal.valueOf(300000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=400000)
                        result=result.add(BigDecimal.valueOf(60000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.15)));
                    tot=tot.subtract(BigDecimal.valueOf(400000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=500000)
                        result=result.add(BigDecimal.valueOf(100000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.2)));
                    tot=tot.subtract(BigDecimal.valueOf(500000));
                }
                if(tot.intValue()>0)
                {

                    result=result.add(tot.multiply(BigDecimal.valueOf(.25)));
                    tot=BigDecimal.ZERO;
                }

                taxResult.setBasicsalary(Yearlybasic);
                taxResult.setHouserent(houserent);
                taxResult.setConveyance(conv);
                taxResult.setOthers(other);
                taxResult.setFestival(fesival);
                taxResult.setTotal(store);
                taxResult.setTotalyearlytax(result);
                taxResult.setMedical(BigDecimal.ZERO);

            }
            else if(tax.getZoon().equals("Sylhet"))
            {


                if(tot.intValue()>0)
                {

                    tot=tot.subtract(BigDecimal.valueOf(300000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=100000)
                        result=result.add(BigDecimal.valueOf(5000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.02)));

                    tot=tot.subtract(BigDecimal.valueOf(100000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=300000)
                        result=result.add(BigDecimal.valueOf(30000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.04)));
                    tot=tot.subtract(BigDecimal.valueOf(300000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=400000)
                        result=result.add(BigDecimal.valueOf(60000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.06)));
                    tot=tot.subtract(BigDecimal.valueOf(400000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=500000)
                        result=result.add(BigDecimal.valueOf(100000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.10)));
                    tot=tot.subtract(BigDecimal.valueOf(500000));
                }
                if(tot.intValue()>0)
                {

                    result=result.add(tot.multiply(BigDecimal.valueOf(.20)));
                    tot=BigDecimal.ZERO;
                }
                taxResult.setBasicsalary(Yearlybasic);
                taxResult.setHouserent(houserent);
                taxResult.setConveyance(conv);
                taxResult.setOthers(other);
                taxResult.setFestival(fesival);
                taxResult.setTotal(store);
                taxResult.setTotalyearlytax(result);
                taxResult.setMedical(BigDecimal.ZERO);

            }
            else
            {

                if(tot.intValue()>0)
                {

                    tot=tot.subtract(BigDecimal.valueOf(300000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=100000)
                        result=result.add(BigDecimal.valueOf(5000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.04)));

                    tot=tot.subtract(BigDecimal.valueOf(100000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=300000)
                        result=result.add(BigDecimal.valueOf(30000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.08)));
                    tot=tot.subtract(BigDecimal.valueOf(300000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=400000)
                        result=result.add(BigDecimal.valueOf(60000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.12)));
                    tot=tot.subtract(BigDecimal.valueOf(400000));
                }
                if(tot.intValue()>0)

                {
                    if(tot.intValue()>=500000)
                        result=result.add(BigDecimal.valueOf(100000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.15)));
                    tot=tot.subtract(BigDecimal.valueOf(500000));
                }
                if(tot.intValue()>0)
                {

                    result=result.add(tot.multiply(BigDecimal.valueOf(.20)));
                    tot=BigDecimal.ZERO;
                }
                taxResult.setBasicsalary(Yearlybasic);
                taxResult.setHouserent(houserent);
                taxResult.setConveyance(conv);
                taxResult.setOthers(other);
                taxResult.setFestival(fesival);
                taxResult.setTotal(store);
                taxResult.setTotalyearlytax(result);
                taxResult.setMedical(BigDecimal.ZERO);
            }
        }
        else
        {
            conv=tax.getConveyance()
                    .multiply(BigDecimal.valueOf(12))
                    .subtract(BigDecimal.valueOf(40000));
            conv=conv.intValue()<0?BigDecimal.ZERO:conv;

            if(tax.getZoon().equals("Dhaka"))
            {

                if(tot.intValue()>0)
                {
                    tot=tot.subtract(BigDecimal.valueOf(300000));

                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=100000)
                        result=result.add(BigDecimal.valueOf(5000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.05)));

                    tot=tot.subtract(BigDecimal.valueOf(100000));

                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=300000)
                        result=result.add(BigDecimal.valueOf(30000));

                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.1)));

                    tot=tot.subtract(BigDecimal.valueOf(300000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=400000)
                        result=result.add(BigDecimal.valueOf(60000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.15)));
                    tot=tot.subtract(BigDecimal.valueOf(400000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=500000)
                        result=result.add(BigDecimal.valueOf(100000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.2)));
                    tot=tot.subtract(BigDecimal.valueOf(500000));
                }
                if(tot.intValue()>0)
                {

                    result=result.add(tot.multiply(BigDecimal.valueOf(.25)));
                    tot=BigDecimal.ZERO;
                }

                taxResult.setBasicsalary(Yearlybasic);
                taxResult.setHouserent(houserent);
                taxResult.setConveyance(conv);
                taxResult.setOthers(other);
                taxResult.setFestival(fesival);
                taxResult.setTotal(store);
                taxResult.setTotalyearlytax(result);
                taxResult.setMedical(BigDecimal.ZERO);
            }
            else if(tax.getZoon().equals("Sylhet"))
            {


                if(tot.intValue()>0)
                {

                    tot=tot.subtract(BigDecimal.valueOf(300000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=100000)
                        result=result.add(BigDecimal.valueOf(5000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.02)));

                    tot=tot.subtract(BigDecimal.valueOf(100000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=300000)
                        result=result.add(BigDecimal.valueOf(30000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.04)));
                    tot=tot.subtract(BigDecimal.valueOf(300000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=400000)
                        result=result.add(BigDecimal.valueOf(60000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.06)));
                    tot=tot.subtract(BigDecimal.valueOf(400000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=500000)
                        result=result.add(BigDecimal.valueOf(100000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.10)));
                    tot=tot.subtract(BigDecimal.valueOf(500000));
                }
                if(tot.intValue()>0)
                {

                    result=result.add(tot.multiply(BigDecimal.valueOf(.20)));
                    tot=BigDecimal.ZERO;
                }
                taxResult.setBasicsalary(Yearlybasic);
                taxResult.setHouserent(houserent);
                taxResult.setConveyance(conv);
                taxResult.setOthers(other);
                taxResult.setFestival(fesival);
                taxResult.setTotal(store);
                taxResult.setTotalyearlytax(result);
                taxResult.setMedical(BigDecimal.ZERO);

            }
            else
            {

                if(tot.intValue()>0)
                {

                    tot=tot.subtract(BigDecimal.valueOf(300000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=100000)
                        result=result.add(BigDecimal.valueOf(5000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.04)));

                    tot=tot.subtract(BigDecimal.valueOf(100000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=300000)
                        result=result.add(BigDecimal.valueOf(30000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.08)));
                    tot=tot.subtract(BigDecimal.valueOf(300000));
                }
                if(tot.intValue()>0)
                {
                    if(tot.intValue()>=400000)
                        result=result.add(BigDecimal.valueOf(60000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.12)));
                    tot=tot.subtract(BigDecimal.valueOf(400000));
                }
                if(tot.intValue()>0)

                {
                    if(tot.intValue()>=500000)
                        result=result.add(BigDecimal.valueOf(100000));
                    else
                        result=result.add(tot.multiply(BigDecimal.valueOf(.15)));
                    tot=tot.subtract(BigDecimal.valueOf(500000));
                }
                if(tot.intValue()>0)
                {

                    result=result.add(tot.multiply(BigDecimal.valueOf(.20)));
                    tot=BigDecimal.ZERO;
                }
                taxResult.setBasicsalary(Yearlybasic);
                taxResult.setHouserent(houserent);
                taxResult.setConveyance(conv);
                taxResult.setOthers(other);
                taxResult.setFestival(fesival);
                taxResult.setTotal(store);
                taxResult.setTotalyearlytax(result);
                taxResult.setMedical(BigDecimal.ZERO);
            }
        }


        return taxResult;
    }

    @Transactional
    public List<Tax> getAllByUserName(String name) {
        return taxRepository.findAllByUserName(name);
    }

}
