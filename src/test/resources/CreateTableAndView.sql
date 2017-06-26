CREATE TABLE [dbo].[ISBG_Project_Finish](
	[ID] [varchar](50) NOT NULL,
	[StartTime] [datetime] NULL,
	[EndTime] [datetime] NULL,
	[ProjectId] [varchar](50) NULL,
	[ProjectNo] [varchar](250) NULL,
	[Statues] [int] NULL,
	[IsSubmit] [bit] NULL,
	[CreateWorkId] [varchar](200) NULL,
	[CreateUserName] [varchar](200) NULL,
	[CreateTime] [datetime] NULL,
	[WorkdNum] [float] NULL,
	[EndName] [varchar](1000) NULL,
	[Remark] [varchar](2000) NULL,
	[PONumber] [varchar](2000) NULL,
	[POMark] [int] NULL,
	[ProjectStartDateTime] [datetime] NULL,
	[ProjectEndDateTime] [datetime] NULL,
	[WorkEvaluate] [float] NULL,
	[ActiveCost] [float] NULL,
	[ActiveBSM] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'实际成本' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ISBG_Project_Finish', @level2type=N'COLUMN',@level2name=N'ActiveCost'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'实际BSM' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ISBG_Project_Finish', @level2type=N'COLUMN',@level2name=N'ActiveBSM'
GO

CREATE VIEW [dbo].[PDRC_V_StaffList]
AS
SELECT     dbo.PDRC_StaffManage.ID, dbo.PDRC_StaffManage.TM, dbo.PDRC_StaffManage.TMName, dbo.PDRC_StaffManage.WorkID, dbo.PDRC_StaffManage.UserName, 
                      dbo.PDRC_StaffManage.NormalMam, dbo.PDRC_StaffManage.Salary, dbo.PDRC_StaffManage.AddPer, dbo.PDRC_StaffManage.AddDate, 
                      dbo.PDRC_StaffManage.InDate, b.RMWorkID AS RM, a.UserName AS RMName, a.DepartID AS RMDepartID, a.Email AS RMEmail
FROM         dbo.PDRC_StaffManage INNER JOIN
                      dbo.PDRC_TM AS b ON b.WorkID = dbo.PDRC_StaffManage.TM LEFT OUTER JOIN
                      dbo.T_Users AS a ON b.RMWorkID = a.WorkId
WHERE     (dbo.PDRC_StaffManage.DelDate IS NULL)

GO