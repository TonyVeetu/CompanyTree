package companytest;

import company.Company;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CompanyTest {
    private Company a;
    private Company b_a; private Company d_a;
    private Company c_ba; private Company e_da;

    private ArrayList<Company> list = new ArrayList<Company>();

    @Before
    public void init(){
        a = new Company("A",null, 5);
        b_a = new Company("B",a, 10);
        c_ba = new Company("C", b_a, 23);
        d_a = new Company("D", a, 13);
        e_da = new Company("E", d_a, 2);
        list.add(a); list.add(b_a); list.add(c_ba); list.add(d_a); list.add(e_da);
    }

    @Test
    public void getSuperCompanyTest(){
        System.out.println("____Test_1_____");
        System.out.println(c_ba.getTopLevelParent(c_ba).getName());
    }

    @Test
    public void getEmployeeCountForCompanyAndChildrenTest(){
        System.out.println("____Test_2_____");
        System.out.println(a.getEmployeeCountForCompanyAndChildren(a, list));
    }
}
