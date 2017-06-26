/****** Object:  View [dbo].[PDRC_V_StaffList]    Script Date: 05/09/2017 15:08:05 ******/
IF  EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[PDRC_V_StaffList]'))
DROP VIEW [dbo].[PDRC_V_StaffList]
GO

/****** Object:  Table [dbo].[ISBG_Project_Finish]    Script Date: 05/09/2017 15:09:20 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ISBG_Project_Finish]') AND type in (N'U'))
DROP TABLE [dbo].[ISBG_Project_Finish]
GO