package company;

import java.util.ArrayList;
import java.util.List;

public class Company implements ICompanyService{
    private final Company parent;
    private final long employeeCount;
    private String name;

    public Company(String name,Company parent, long employeeCount) {
        this.name = name;
        this.parent = parent;
        this.employeeCount = employeeCount;
    }

    public String getName() {
        return name;
    }

    public Company getParent(){
        return parent;

    }
    public Company getTopLevelParent(Company child){
        Company parent = child.getParent();
        Company children = null;
        while(parent != null) {
            children = parent;
            parent = parent.getParent();
        }
        return children;
    }

    public long getEmployeeCount(){
        return employeeCount;
    }

    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies){
        long employCount = 0;
        employCount += company.getEmployeeCount();
        ArrayList<Company> parents = new ArrayList<Company>();
        parents.add(company);

        while(parents != null) {
            ArrayList<Company> children = new ArrayList<Company>();
            for (int i = 0; i < companies.size(); i++) {
                for(int j = 0; j < parents.size(); j++) {
                    if(companies.get(i).getParent() != null) {
                        if ((companies.get(i).getParent()).equals(parents.get(j))) {
                            children.add(companies.get(i));
                        }
                    }
                }
            }
            if(children.isEmpty()){
                break;
            }
            else {
                for (int i = 0; i < children.size(); i++) {
                    System.out.println();
                    employCount += children.get(i).getEmployeeCount();
                }
                parents.clear();
                parents.addAll(children);
                children.clear();
            }
        }
        return employCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (employeeCount != company.employeeCount) return false;
        if (!parent.equals(company.parent)) return false;
        return name.equals(company.name);
    }

    @Override
    public int hashCode() {
        int result = parent.hashCode();
        result = 31 * result + (int) (employeeCount ^ (employeeCount >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }
}
