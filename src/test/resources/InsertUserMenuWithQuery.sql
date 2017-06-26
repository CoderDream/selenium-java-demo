INSERT INTO T_UserMenu
(UserId,
 MenuId
)
VALUES
(
(
    SELECT ID
    FROM T_Users
    WHERE WorkId = 'B-29685'
),
(
    SELECT ID
    FROM T_MenuInfo
    WHERE Name = 'BSMÃ÷Ï¸²éÑ¯'
)
);
GO