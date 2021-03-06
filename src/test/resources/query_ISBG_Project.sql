/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP 1000 [ID]
      --,[ParentID]
      --,[ProjectNo]
      --,[ProjectName]
      --,[ProjectMgr_WorkID]
      --,[ProjectMgr_Name]
      --,[Company]
      --,[DepartmentID]
      --,[DepartmentName]
      --,[OEProList]
      --,[ProjectType]
      --,[ProjectSubType]
      --,[ProjectStartDate]
      --,[ProjectEndDate]
      --,[CustomerNo]
      --,[CustomerName]
      --,[CustomerDep]
      --,[ProductFamilyName]
      --,[ProductName]
      --,[Technology]
      --,[DeliveryType]
      --,[CustomerPM]
      --,[BU_Manager]
      --,[PersonTotal]
      --,[CooperationType]
      --,[OBDORPPC]
      --,[WIP]
      --,[stock]
      --,[ProState]
      --,[isJump]
      --,[ProComputerTime]
      --,[CreateWorkID]
      --,[BU_Manager_WorkID]
      --,[BU_Manager_Name]
      --,[Pro_ThreeDepartmentID]
      --,[Pro_ThreeDepartmentName]
      --,[Pro_FourDepartmentID]
      --,[Pro_FourDepartmentName]
      --,[ClientProductPM]
      --,[ClientProjectPM]
      --,[BJCProductPMWork_ID]
      --,[BJCProductPMName]
      --,[QAWork_ID]
      --,[QAName]
      --,[ProjectType2]
      --,[ProjectTechnosphere]
      --,[ProjectStartDateTime]
      --,[ProjectEndDateTime]
      --,[DeliveryAddress]
      --,[ISQASupport]
      --,[WorkEvaluate]
      ----,[DemandRange]
      --,[ProStatePPC]
      --,[isJumpPPC]
      --,[BudgetCustomerNO]
      --,[BudgetCustomerName]
      --,[OEProjectNO]
      --,[OEProjectName]
      --,[EntryDate]
      --,[BeProduct]
      --,[BeProductName]
      --,[IsOtherplace]
      --,[TeamSize]
      --,[CalendarID]
      --,[CalendarName]
      --,[CreateName]
      --,[CreateDate]
      --,[DeliveryCity]
      --,[DeliveryCityID]
      --,[AreaType]
      --,[IsSite]
      --,[IsFinish]
      --,[EndName]
      --,[ProjectAK]
      --,[IsOrder]
      --,[OrderDate]
      --,[OrderMoney]
      --,[ApplicationDate]
      ----,[ProjectDescr]
      --,[ProjectTypes]
      --,[ContractNo]
      --,[ContractName]
      --,[ReadyType]
      --,[FirstCustomNo]
      --,[FirstCustomName]
      --,[SecondCustomNo]
      --,[SecondCustomName]
      --,[ThirdCustomNo]
      --,[ThirdCustomName]
      --,[LevelName]
      --,[IsOld]
      --,[IsContinue]
      --,[ProjectNewNo]
      --,[BaseType]
      --,[OverTimePayTimes]
      --,[PDRC]
      --,[PlanIncome]
      --,[PlanCost]
      --,[SubcontractorIncome]
      --,[SubcontractorCost]
      --,[IsTestProject]
      --,[PD_DepartID]
      --,[PD_DepartName]
      ,ip.ProjectNo
     -- ,ip.ProjectNewNo
      ,ip.ProjectName
      ,ip.ProjectMgr_WorkID
      ,ip.ProjectMgr_Name
      ,ip.ProjectStartDateTime
      ,ip.ProjectEndDateTime
      ,ip.PDRC
      ,ip.IsFinish      
  FROM [BJC_Finance_Test].[dbo].[ISBG_Project] ip
  where  1=1
  and ip.ParentID is null 
  and ip.ProjectNo is not null 
  -- and ip.ProjectNewNo is not null
  and ip.ProjectStartDateTime is not null
  order by ip.ProjectEndDateTime desc