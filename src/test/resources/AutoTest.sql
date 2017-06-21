-- 
SELECT *
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
       p.ProjectName
FROM ISBG_Project p
WHERE p.ProjectMgr_WorkID = 'B-26050'
	   AND ProjectName = 'PDRCTest';
  

-- 创建的项目这两个状态都为2  
SELECT p.ProState,
       p.ProStatePPC,
       p.ProjectName
FROM ISBG_Project p
WHERE p.ProjectMgr_WorkID = 'B-26050'
      AND p.ParentID = '693cb851-ba8d-40cf-a60f-ac0356885128';
     -- AND ProjectName = 'PDRC_DEV_Test';
      
      
      D-201703-1253
      
INSERT INTO [dbo].[ISBG_Project] ( [ID] , ParentID , ProjectName , ProjectMgr_WorkID , ProjectMgr_Name , Company , DepartmentID , DepartmentName , CustomerNo , CustomerName , Technology , CooperationType , OBDORPPC , stock , ProState , isJump , ProComputerTime , CreateWorkID , ProjectTechnosphere , ProjectStartDateTime , ProjectEndDateTime , WorkEvaluate , ProStatePPC , isJumpPPC , EntryDate , IsOtherplace , TeamSize , CalendarID , CalendarName , CreateName , CreateDate , DeliveryCity , DeliveryCityID , AreaType , IsSite , IsFinish , ProjectAK , OrderDate , OrderMoney , ProjectDescr , ProjectTypes , ReadyType , IsOld , ProjectNewNo , BaseType , PDRC , PlanIncome , PlanCost , SubcontractorIncome , SubcontractorCost , IsTestProject , PD_DepartID , PD_DepartName , MajorIncome , MajorCost , PassThroughIncome , PassThroughCost , TravelIncome
                                 )
VALUES ( NEWID() , N'693cb851-ba8d-40cf-a60f-ac0356885128' , N'PDRC_DEV_Test_201706211535' , N'B-26050' , N'李鹏' , N'武汉佰钧成技术有限责任公司' , N'1327' , N'ISBG-BU1' , N'106' , N'华为-华为IT' , N'移动类' , N'FP' , N'PPC' , N'1678' , N'2' , N'0' , N'2017-06-21' , N'B-26050' , N'.NET' , N'2017-06-22' , N'2017-06-23' , N'100' , N'2' , N'1' , N'2017-06-21' , N'否' , N'20' , N'1' , N'标准工作日历' , N'李鹏' , N'2017-06-21' , N'武汉' , N'1' , N'一类区域' , N'Offsite' , N'1' , N'PDRC_DEV_Test' , N'2017-06-21' , N'800000' , N'aaa' , N'交付项目' , N'产品' , N'1' , N'D-201706-1678' , N'客户管理中心-客户群2' , N'150000' , N'0' , N'0' , N'0' , N'0' , N'1' , N'1535' , N'ISBG-生产力促进中心-项目管理中心' , N'0' , N'0' , N'0' , N'0' , N'0'
       );


DELETE FROM ISBG_Project WHERE ID = 'EA056AA0-D58A-4E6C-99E5-8AFD389740BD'
      