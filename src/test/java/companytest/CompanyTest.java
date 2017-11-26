package companytest;

import company.Company;
import org.junit.Assert;
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

    /**             Example: E(e_da) = 2 => E - name, e_da - name of ref, 2 - count of employee!
     *                   A = 5
     *                 /       \
     *         10 = B(b_a)   D(d_a) = 13
     *             /           \
     *   23 = C(c_ba)        E(e_da) = 2
     *            */

    @Test
    public void getSuperCompanyTest(){
        Assert.assertTrue("A".equals(c_ba.getTopLevelParent(c_ba).getName()));
    }

    @Test
    public void getEmployeeCountForCompanyAndChildrenTest(){
        Assert.assertTrue( 53 == a.getEmployeeCountForCompanyAndChildren(a, list));
        Assert.assertTrue( 23 == a.getEmployeeCountForCompanyAndChildren(c_ba, list));
        Assert.assertTrue( 2 == a.getEmployeeCountForCompanyAndChildren(e_da, list));
    }
}
