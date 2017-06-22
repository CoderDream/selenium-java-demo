-- 用sql获取数据库中所有的表名的方法：
SELECT *
FROM sys.tables order by name;

--获取SqlServer中表结构 
SELECT syscolumns.name,
       systypes.name,
       syscolumns.isnullable,
       syscolumns.length
FROM syscolumns,
     systypes
WHERE syscolumns.xusertype = systypes.xusertype
      AND syscolumns.id = OBJECT_ID('PDRC_StaffManage');
      
-- 2.如果还想要获取字段的描述信息则      
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


-- 主键约束
SELECT tab.name AS [表名],
       idx.name AS [主键名称],
       col.name AS [主键列名]
FROM sys.indexes idx
     JOIN sys.index_columns idxCol ON(idx.object_id = idxCol.object_id
                                      AND idx.index_id = idxCol.index_id
                                      AND idx.is_primary_key = 1)
     JOIN sys.tables tab ON(idx.object_id = tab.object_id)
     JOIN sys.columns col ON(idx.object_id = col.object_id
                             AND idxCol.column_id = col.column_id) order by tab.name;

-- 唯一约束
SELECT
  tab.name AS [表名],
  idx.name AS [约束名称],
  col.name AS [约束列名]
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

-- 外键约束
SELECT oSub.name AS [子表名称],
       fk.name AS [外键名称],
       SubCol.name AS [子表列名],
       oMain.name AS [主表名称],
       MainCol.name AS [主表列名]
FROM sys.foreign_keys fk
     JOIN sys.all_objects oSub ON(fk.parent_object_id = oSub.object_id)
     JOIN sys.all_objects oMain ON(fk.referenced_object_id = oMain.object_id)
     JOIN sys.foreign_key_columns fkCols ON(fk.object_id = fkCols.constraint_object_id)
     JOIN sys.columns SubCol ON(oSub.object_id = SubCol.object_id
                                AND fkCols.parent_column_id = SubCol.column_id)
     JOIN sys.columns MainCol ON(oMain.object_id = MainCol.object_id
                                 AND fkCols.referenced_column_id = MainCol.column_id)
ORDER BY oSub.name;

-- Check约束
SELECT
  tab.name AS [表名],
  chk.name AS [Check约束名],
  col.name AS [列名],
  chk.definition
FROM
  sys.check_constraints chk
    JOIN sys.tables tab
      ON (chk.parent_object_id = tab.object_id)
    JOIN sys.columns col
      ON (chk.parent_object_id = col.object_id
          AND chk.parent_column_id = col.column_id);
          
-- 获取表名及表的触发器
/*
select 
 (select b.name from sysobjects as b where b.id = a.parent_obj)  表名,
   a.name  as 触发器 
   from sysobjects  as a where a.xtype='TR'
order by 表名
备注：
 xtype   char(2)   对象类型。可以是下列对象类型中的一种：     
  C   =   CHECK   约束   
  D   =   默认值或   DEFAULT   约束   
  F   =   FOREIGN   KEY   约束   
  L   =   日志   
  FN   =   标量函数   
  IF   =   内嵌表函数   
  P   =   存储过程   
  PK   =   PRIMARY   KEY   约束（类型是   K）   
  RF   =   复制筛选存储过程   
  S   =   系统表   
  TF   =   表函数   
  TR   =   触发器   
  U   =   用户表   
  UQ   =   UNIQUE   约束（类型是   K）   
  V   =   视图   
  X   =   扩展存储过程  
      */
