/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();

        // Store employees by their ID
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        return dfs(map, id);
    }
}