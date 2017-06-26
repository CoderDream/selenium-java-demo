select Project_ID,Staff_WorkID,c 
from  (select Project_ID,Staff_WorkID,count(ID) as c from dbo.ISBG_HumanMap group by Project_ID,Staff_WorkID) a 
where a.c>=2;

select * from dbo.ISBG_HumanMap t
where t.Project_ID='04473a5d-5ad2-42bd-b73a-9a93af43d410' and t.Staff_WorkID='B-13416';