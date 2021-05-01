package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 690. 员工的重要性
 *
 * https://leetcode-cn.com/problems/employee-importance/
 */
public class GetImportance {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>((int) (employees.size() / .75d) + 1);
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return sum(map, id);
    }

    private int sum(Map<Integer, Employee> map, int id) {
        Employee employee = map.get(id);
        if (employee.subordinates.isEmpty()) {
            return employee.importance;
        }
        int importance = employee.importance;
        for (Integer subordinate : employee.subordinates) {
            importance += sum(map, subordinate);
        }
        return importance;
    }

    public static void main(String[] args) {
        GetImportance getImportance = new GetImportance();

        int importance = getImportance.getImportance(Arrays.asList(Employee.of(1, 5, Arrays.asList(2, 3)),
                Employee.of(2, 3, Arrays.asList()),
                Employee.of(3, 3, Arrays.asList())
        ), 1);
        Assertions.assertThat(importance).isEqualTo(11);

    }

}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public static Employee of(int id, int importance, List<Integer> subordinates) {
        Employee employee = new Employee();
        employee.id = id;
        employee.importance = importance;
        employee.subordinates = subordinates;
        return employee;
    }
}
