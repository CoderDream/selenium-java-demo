SELECT psm.TM,
       SUM(psm.Salary)
FROM PDRC_StaffManage psm
GROUP BY psm.TM;