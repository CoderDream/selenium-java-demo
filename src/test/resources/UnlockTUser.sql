update T_Users set isLock=NULL 
where WorkID in (select WorkId from PDRC_TM 
union select WorkID from PDRC_RM 
union select PDM_WorkID from PDRC_PDM 
union select PGM_WorkID from PDRC_PGM 
union select PM_WorkID from PDRC_PM
union select WorkID from PDRC_StaffManage
)