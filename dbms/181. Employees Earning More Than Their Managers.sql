SELECT
a.NAME AS Employee
FROM Employee AS a JOIN Employee As b
On a.ManagerId=b.Id
AND a.salary>b.salary