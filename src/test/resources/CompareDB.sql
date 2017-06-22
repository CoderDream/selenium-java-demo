-- ��sql��ȡ���ݿ������еı����ķ�����
SELECT *
FROM sys.tables order by name;

--��ȡSqlServer�б�ṹ 
SELECT syscolumns.name,
       systypes.name,
       syscolumns.isnullable,
       syscolumns.length
FROM syscolumns,
     systypes
WHERE syscolumns.xusertype = systypes.xusertype
      AND syscolumns.id = OBJECT_ID('PDRC_StaffManage');
      
-- 2.�������Ҫ��ȡ�ֶε�������Ϣ��      
SELECT sys.columns.name,
       sys.types.name,
       sys.columns.max_length,
       sys.columns.is_nullable,
(
    SELECT COUNT(*)
    FROM sys.identity_columns
    WHERE sys.identity_columns.object_id = sys.columns.object_id
          AND sys.columns.column_id = sys.identity_columns.column_id
) AS is_identity,
(
    SELECT value
    FROM sys.extended_properties
    WHERE sys.extended_properties.major_id = sys.columns.object_id
          AND sys.extended_properties.minor_id = sys.columns.column_id
) AS description
FROM sys.columns,
     sys.tables,
     sys.types
WHERE sys.columns.object_id = sys.tables.object_id
      AND sys.columns.system_type_id = sys.types.system_type_id
      AND sys.tables.name = 'PDRC_StaffManage'
ORDER BY sys.columns.column_id;


-- ����Լ��
SELECT tab.name AS [����],
       idx.name AS [��������],
       col.name AS [��������]
FROM sys.indexes idx
     JOIN sys.index_columns idxCol ON(idx.object_id = idxCol.object_id
                                      AND idx.index_id = idxCol.index_id
                                      AND idx.is_primary_key = 1)
     JOIN sys.tables tab ON(idx.object_id = tab.object_id)
     JOIN sys.columns col ON(idx.object_id = col.object_id
                             AND idxCol.column_id = col.column_id) order by tab.name;

-- ΨһԼ��
SELECT
  tab.name AS [����],
  idx.name AS [Լ������],
  col.name AS [Լ������]
FROM
  sys.indexes idx
    JOIN sys.index_columns idxCol 
      ON (idx.object_id = idxCol.object_id 
          AND idx.index_id = idxCol.index_id 
          AND idx.is_unique_constraint = 1)
    JOIN sys.tables tab
      ON (idx.object_id = tab.object_id)
    JOIN sys.columns col
      ON (idx.object_id = col.object_id
          AND idxCol.column_id = col.column_id);

-- ���Լ��
SELECT oSub.name AS [�ӱ�����],
       fk.name AS [�������],
       SubCol.name AS [�ӱ�����],
       oMain.name AS [��������],
       MainCol.name AS [��������]
FROM sys.foreign_keys fk
     JOIN sys.all_objects oSub ON(fk.parent_object_id = oSub.object_id)
     JOIN sys.all_objects oMain ON(fk.referenced_object_id = oMain.object_id)
     JOIN sys.foreign_key_columns fkCols ON(fk.object_id = fkCols.constraint_object_id)
     JOIN sys.columns SubCol ON(oSub.object_id = SubCol.object_id
                                AND fkCols.parent_column_id = SubCol.column_id)
     JOIN sys.columns MainCol ON(oMain.object_id = MainCol.object_id
                                 AND fkCols.referenced_column_id = MainCol.column_id)
ORDER BY oSub.name;

-- CheckԼ��
SELECT
  tab.name AS [����],
  chk.name AS [CheckԼ����],
  col.name AS [����],
  chk.definition
FROM
  sys.check_constraints chk
    JOIN sys.tables tab
      ON (chk.parent_object_id = tab.object_id)
    JOIN sys.columns col
      ON (chk.parent_object_id = col.object_id
          AND chk.parent_column_id = col.column_id);
          
-- ��ȡ��������Ĵ�����
/*
select 
 (select b.name from sysobjects as b where b.id = a.parent_obj)  ����,
   a.name  as ������ 
   from sysobjects  as a where a.xtype='TR'
order by ����
��ע��
 xtype   char(2)   �������͡����������ж��������е�һ�֣�     
  C   =   CHECK   Լ��   
  D   =   Ĭ��ֵ��   DEFAULT   Լ��   
  F   =   FOREIGN   KEY   Լ��   
  L   =   ��־   
  FN   =   ��������   
  IF   =   ��Ƕ����   
  P   =   �洢����   
  PK   =   PRIMARY   KEY   Լ����������   K��   
  RF   =   ����ɸѡ�洢����   
  S   =   ϵͳ��   
  TF   =   ����   
  TR   =   ������   
  U   =   �û���   
  UQ   =   UNIQUE   Լ����������   K��   
  V   =   ��ͼ   
  X   =   ��չ�洢����  
      */
