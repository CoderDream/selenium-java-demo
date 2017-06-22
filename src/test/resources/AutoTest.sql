-- 
SELECT *
FROM ISBG_Project p
WHERE p.ProjectMgr_WorkID = 'B-26050'
      AND p.ParentID = '693cb851-ba8d-40cf-a60f-ac0356885128';
--AND ProjectName = 'PDRC_DEV_Test';


SELECT p.ProState,
       p.ProStatePPC,
       p.ProjectName,
       p.ProjectStartDateTime,
       p.ProjectEndDateTime
FROM ISBG_Project p
WHERE p.ProjectMgr_WorkID = 'B-26050'
      AND p.ParentID = '693cb851-ba8d-40cf-a60f-ac0356885128';
--AND ProjectName = 'PDRC_DEV_Test';

SELECT *
FROM ISBG_Project p
WHERE p.ProjectMgr_WorkID = 'B-26050'
	   AND ProjectName = 'PDRCTest';
	   
SELECT p.ProState,
       p.ProStatePPC,
       p.ProjectName,
       p.ProjectStartDateTime,
       p.ProjectEndDateTime,
       p.ProComputerTime,
       p.OrderDate,
       p.EntryDate
FROM ISBG_Project p
WHERE p.ProjectMgr_WorkID = 'B-26050'
	   AND ProjectName = 'P06211624';
  

-- 创建的项目这两个状态都为2  
SELECT p.ProState,
       p.ProStatePPC,
       p.ProjectName
FROM ISBG_Project p
WHERE p.ProjectMgr_WorkID = 'B-26050'
      AND p.ParentID = '693cb851-ba8d-40cf-a60f-ac0356885128';
     -- AND ProjectName = 'PDRC_DEV_Test';
      
      

      
INSERT INTO [dbo].[ISBG_Project] ([ID],ParentID,ProjectName,ProjectMgr_WorkID,ProjectMgr_Name,Company,DepartmentID,DepartmentName,CustomerNo,CustomerName,Technology,CooperationType,OBDORPPC,stock,ProState,isJump,ProComputerTime,CreateWorkID,ProjectTechnosphere,ProjectStartDateTime,ProjectEndDateTime,WorkEvaluate,ProStatePPC,isJumpPPC,EntryDate,IsOtherplace,TeamSize,CalendarID,CalendarName,CreateName,CreateDate,DeliveryCity,DeliveryCityID,AreaType,IsSite,IsFinish,ProjectAK,OrderDate,OrderMoney,ProjectDescr,ProjectTypes,ReadyType,IsOld,ProjectNewNo,BaseType,PDRC,PlanIncome,PlanCost,SubcontractorIncome,SubcontractorCost,IsTestProject,PD_DepartID,PD_DepartName,MajorIncome,MajorCost,PassThroughIncome,PassThroughCost,TravelIncome) VALUES(newid(),N'693cb851-ba8d-40cf-a60f-ac0356885128',N'P06211624',N'B-26050',N'李鹏',N'武汉佰钧成技术有限责任公司',N'1327',N'ISBG-BU1',N'106',N'华为-华为IT',N'移动类',N'FP',N'PPC',N'1678',N'2',N'0',N'2017-06-21',N'B-26050',N'.NET',N'2017-06-21',N'2017-06-21',N'100',N'2',N'1',N'2017-06-21',N'否',N'20',N'1',N'标准工作日历',N'李鹏',N'2017-06-21',N'武汉',N'1',N'一类区域',N'Offsite',N'0',N'PDRC_DEV_Test',N'2017-06-21',N'800000',N'aaa',N'交付项目',N'产品',N'1',N'D-201706-1678',N'客户管理中心-客户群2',N'150000',N'0',N'0',N'0',N'0',N'1',N'1535',N'ISBG-生产力促进中心-项目管理中心',N'0',N'0',N'0',N'0',N'0');


UPDATE ISBG_Project
  SET
      ProjectStartDateTime = N'2017-6-22',
      ProjectEndDateTime = N'2017-6-22',
      ProComputerTime = N'2017-6-22',
      OrderDate = N'2017-6-22',
      EntryDate = N'2017-6-22'
WHERE ID = '4A6251B4-1E00-403D-A3F8-8453EBA1C3C1';

DELETE FROM ISBG_Project WHERE ID = '4A6251B4-1E00-403D-A3F8-8453EBA1C3C1';
     
     
     
/****** Script for SelectTopNRows command from SSMS  ******/
SELECT ID
      ,bd.ProjectID
      ,bd.WorkID
      ,bd.DispatchMonth
      ,bd.ConfrimTime
      ,bd.BSMState
      ,bd.BSM
  FROM PDRC_BSM_Dispatch bd
  where bd.WorkID=N'B-024';
  
  
  /****** Script for SelectTopNRows command from SSMS  ******/
SELECT [ID]
      ,[Staff_WorkID]
      ,[Customer_WorkID]
      ,[Staff_Name]
      ,[Gender]
      ,[DepartmentID]
      ,[DepartmentName]
      ,[Project_ID]
      ,[CustomerNo]
      ,[CustomerName]
      ,[CustomerDep]
      ,[DeliveryType]
      ,[CooperationType]
      ,[Technology]
      ,[PriceType]
      ,[TechnicalTrend]
      ,[ProPosition]
      ,[ExpertLevel]
      ,[BJCPosition]
      ,[EmployeeNature]
      ,[EmployeeState]
      ,[EntryDate]
      ,[InPro_Date]
      ,[InPro_State]
      ,[PositiveDate]
      ,[OutPro_Date]
      ,[TermDate]
      ,[WorkingCity]
      ,[ProjectMgr_WorkID]
      ,[ProjectMgr_Name]
      ,[WorkLocation]
      ,[WorkPlace]
      ,[IsElite]
      ,[OutPro_Reason]
      ,[Remarks]
      ,[P_Type]
      ,[P_IsSite]
      ,[P_AreaType]
      ,[P_ExpertLevel]
      ,[P_LevelDes]
      ,[P_Price]
      ,[P_Currency]
      ,[is_Pay]
      ,[EquipmentName]
      ,[SiteName]
      ,[Create_WorkID]
      ,[Create_WorkName]
      ,[CreateTime]
      ,[Modify_WorkID]
      ,[Modify_WorkName]
      ,[ModifyTime]
      ,[VacancyReason]
      ,[VacancyID]
      ,[VacancyType]
      ,[Predict_OutProDate]
  FROM [BJC_Finance_Test].[dbo].[ISBG_HumanMap] hm
   where hm.Staff_WorkID=N'B-024';