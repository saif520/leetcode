SELECT Department.Name AS Department, Employee.Name AS Employee, Salary
FROM Employee JOIN Department ON Employee.DepartmentId=Department.Id
WHERE (DepartmentId,Salary) IN
(select DepartmentId, Max(Salary) FROM Employee
GROUP BY DepartmentId)