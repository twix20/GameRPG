-- StatisticType
-- ! Wartosci Id musza odpowiadac enumowi StatisticTypeEnum !
insert into StatisticType (Id, Name) values (1, 'Hp');
insert into StatisticType (Id, Name) values (2, 'Mp');
insert into StatisticType (Id, Name) values (3, 'DealDmg');

-- Statistic
insert into Statistic(Id, StatisticType_Id, Value) values (1, 1, 10);
insert into Statistic(Id, StatisticType_Id, Value) values (2, 1, 11);
insert into Statistic(Id, StatisticType_Id, Value) values (3, 1, 12);
insert into Statistic(Id, StatisticType_Id, Value) values (4, 2, 20);
insert into Statistic(Id, StatisticType_Id, Value) values (5, 2, 21);
insert into Statistic(Id, StatisticType_Id, Value) values (6, 2, 22);
insert into Statistic(Id, StatisticType_Id, Value) values (7, 2, 23);
insert into Statistic(Id, StatisticType_Id, Value) values (8, 3, 30);
insert into Statistic(Id, StatisticType_Id, Value) values (9, 3, 31);

-- Item
insert into Item (Id, Name, MaxDurability, Price, Type, DefDamage, Damage, HealValue) values (1, 'Miecz Pelni Ksiezyca', 100, 25, 'SWORD', 0, 10, 0);
insert into Item (Id, Name, MaxDurability, Price, Type, DefDamage, Damage, HealValue) values (2, 'Miecz Grabarza ksiezyca', 100, 35, 'SWORD', 0, 8, 0);
insert into Item (Id, Name, MaxDurability, Price, Type, DefDamage, Damage, HealValue) values (3, 'Armor Spiocha', 100, 45, 'ARMOR', 11, 0, 0);


-- Item_Statistic_XREF
insert into Item_Statistic_XREF (Item_Id, Statistic_Id)
select i.Id, floor(random() * 9 + 1) from Item i;

insert into Item_Statistic_XREF (Item_Id, Statistic_Id)
select i.Id, floor(random() * 9 + 1) from Item i;

-- Player
insert into Player(Id, Nickname, Password, CurrentHp, MaxHp, CurrentMana, MaxMana, CreatedAt, Gold, Type) values(1, 'FakeMag1', '123', 50, 100, 10, 40, CURRENT_TIMESTAMP, 34, 'MAG');
insert into Player(Id, Nickname, Password, CurrentHp, MaxHp, CurrentMana, MaxMana, CreatedAt, Gold, Type) values(2, 'FakeWarrior1', '123', 50, 100, 10, 40, CURRENT_TIMESTAMP, 34, 'WARRIOR');
insert into Player(Id, Nickname, Password, CurrentHp, MaxHp, CurrentMana, MaxMana, CreatedAt, Gold, Type) values(3, 'FakeAdmin1', '123', 50, 100, 10, 40, CURRENT_TIMESTAMP, 34, 'ADMIN');

-- Player_Item_XREF
insert into Player_Item_XREF(Player_Id, Item_Id, CustomItemName, IsEquiped, CurrentDurability) values (1, 1, 'Ziemniak', true, 31);
insert into Player_Item_XREF(Player_Id, Item_Id, CustomItemName, IsEquiped, CurrentDurability) values (1, 2, NULL, false, 32);
insert into Player_Item_XREF(Player_Id, Item_Id, CustomItemName, IsEquiped, CurrentDurability) values (1, 3, NULL, false, NULL);
insert into Player_Item_XREF(Player_Id, Item_Id, CustomItemName, IsEquiped, CurrentDurability) values (2, 2, NULL, false, 34);

-- BattlefieldHistory
insert into BattlefieldHistory(Id, FightStartDate, FightEndDate, WhoWon_Player_Id, Player1_Id, Player2_Id) values (1, to_date('11/02/2016', 'dd/mm/yyyy'), to_date('12/02/2016', 'dd/mm/yyyy'), 1, 1, 2);
insert into BattlefieldHistory(Id, FightStartDate, FightEndDate, WhoWon_Player_Id, Player1_Id, Player2_Id) values (2, to_date('11/02/2017', 'dd/mm/yyyy'), to_date('12/02/2017', 'dd/mm/yyyy'), 2, 2, 1);

-- BattlefieldActionsHistory
insert into BattlefieldActionsHistory(Id, ActionDate, ActionDescription, Value, Battlefield_Id, ActionBy_Player_Id) values (1, to_date('11/02/2016', 'dd/mm/yyyy'), 'Test ActionDescription1', 10, 1, 1);
insert into BattlefieldActionsHistory(Id, ActionDate, ActionDescription, Value, Battlefield_Id, ActionBy_Player_Id) values (2, to_date('12/02/2016', 'dd/mm/yyyy'), 'Test ActionDescription2', 11, 1, 1);
insert into BattlefieldActionsHistory(Id, ActionDate, ActionDescription, Value, Battlefield_Id, ActionBy_Player_Id) values (3, to_date('13/02/2016', 'dd/mm/yyyy'), 'Test ActionDescription3', 12, 1, 1);
insert into BattlefieldActionsHistory(Id, ActionDate, ActionDescription, Value, Battlefield_Id, ActionBy_Player_Id) values (4, to_date('11/03/2016', 'dd/mm/yyyy'), 'Test ActionDescription4', 13, 2, 1);