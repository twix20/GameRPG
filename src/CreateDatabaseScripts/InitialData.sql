--reseed serials
ALTER SEQUENCE StatisticType_id_seq RESTART WITH 1;
ALTER SEQUENCE Statistic_id_seq RESTART WITH 1;
ALTER SEQUENCE Item_id_seq RESTART WITH 1;
ALTER SEQUENCE Player_id_seq RESTART WITH 1;
ALTER SEQUENCE BattlefieldHistory_id_seq RESTART WITH 1;
ALTER SEQUENCE BattlefieldActionsHistory_id_seq RESTART WITH 1;

-- StatisticType
-- ! Wartosci Id musza odpowiadac enumowi StatisticTypeEnum !
insert into StatisticType (Name) values ('Hp');
insert into StatisticType (Name) values ('Mp');
insert into StatisticType (Name) values ('DealDmg');
insert into StatisticType (Name) values ('Def');
insert into StatisticType (Name) values ('Str');
insert into StatisticType (Name) values ('Agi');

-- Statistic
insert into Statistic(StatisticType_Id, Value) values (1, 10);
insert into Statistic(StatisticType_Id, Value) values (1, 11);
insert into Statistic(StatisticType_Id, Value) values (1, 12);
insert into Statistic(StatisticType_Id, Value) values (2, 20);
insert into Statistic(StatisticType_Id, Value) values (2, 21);
insert into Statistic(StatisticType_Id, Value) values (2, 22);
insert into Statistic(StatisticType_Id, Value) values (2, 23);
insert into Statistic(StatisticType_Id, Value) values (3, 30);
insert into Statistic(StatisticType_Id, Value) values (3, 31);

-- Item
insert into Item (Name, Price, Type, DefDamage, Damage, HealValue) values ('Miecz Pelni Ksiezyca', 25, 'SWORD', 0, 10, 0);
insert into Item (Name, Price, Type, DefDamage, Damage, HealValue) values ('Miecz Grabarza ksiezyca', 35, 'SWORD', 0, 8, 0);
insert into Item (Name, Price, Type, DefDamage, Damage, HealValue) values ('Armor Spiocha', 45, 'ARMOR', 11, 0, 0);


-- Item_Statistic_XREF
insert into Item_Statistic_XREF (Item_Id, Statistic_Id)
select i.Id, floor(random() * 9 + 1) from Item i;

insert into Item_Statistic_XREF (Item_Id, Statistic_Id)
select i.Id, floor(random() * 9 + 1) from Item i;

-- Player
insert into Player(Nickname, Password, CurrentHp, MaxHp, CurrentMana, MaxMana, CreatedAt, Gold, Type) values('FakePlayer1', '123', 50, 100, 10, 40, CURRENT_TIMESTAMP, 34, 'PLAYER');
insert into Player(Nickname, Password, CurrentHp, MaxHp, CurrentMana, MaxMana, CreatedAt, Gold, Type) values('FakePlayer2', '123', 50, 100, 10, 40, CURRENT_TIMESTAMP, 34, 'PLAYER');
insert into Player(Nickname, Password, CurrentHp, MaxHp, CurrentMana, MaxMana, CreatedAt, Gold, Type) values('FakeAdmin1', '123', 50, 100, 10, 40, CURRENT_TIMESTAMP, 34, 'ADMIN');

-- Player_Item_XREF
insert into Player_Item_XREF(Player_Id, Item_Id, CustomItemName, IsEquiped) values (1, 1, 'Ziemniak', true);
insert into Player_Item_XREF(Player_Id, Item_Id, CustomItemName, IsEquiped) values (1, 2, NULL, false);
insert into Player_Item_XREF(Player_Id, Item_Id, CustomItemName, IsEquiped) values (1, 3, NULL, false);
insert into Player_Item_XREF(Player_Id, Item_Id, CustomItemName, IsEquiped) values (2, 2, NULL, false);

-- BattlefieldHistory
insert into BattlefieldHistory(FightStartDate, FightEndDate, WhoWon_Player_Id, Player1_Id, Player2_Id) values (to_date('11/02/2016', 'dd/mm/yyyy'), to_date('12/02/2016', 'dd/mm/yyyy'), 1, 1, 2);
insert into BattlefieldHistory(FightStartDate, FightEndDate, WhoWon_Player_Id, Player1_Id, Player2_Id) values (to_date('11/02/2017', 'dd/mm/yyyy'), to_date('12/02/2017', 'dd/mm/yyyy'), 2, 2, 1);

-- BattlefieldActionsHistory
insert into BattlefieldActionsHistory(ActionDate, ActionDescription, Value, Battlefield_Id, ActionBy_Player_Id) values (to_date('11/02/2016', 'dd/mm/yyyy'), 'Test ActionDescription1', 10, 1, 1);
insert into BattlefieldActionsHistory(ActionDate, ActionDescription, Value, Battlefield_Id, ActionBy_Player_Id) values (to_date('12/02/2016', 'dd/mm/yyyy'), 'Test ActionDescription2', 11, 1, 1);
insert into BattlefieldActionsHistory(ActionDate, ActionDescription, Value, Battlefield_Id, ActionBy_Player_Id) values (to_date('13/02/2016', 'dd/mm/yyyy'), 'Test ActionDescription3', 12, 1, 1);
insert into BattlefieldActionsHistory(ActionDate, ActionDescription, Value, Battlefield_Id, ActionBy_Player_Id) values (to_date('11/03/2016', 'dd/mm/yyyy'), 'Test ActionDescription4', 13, 2, 1);