-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2017-12-28 17:17:46.076

-- tables
-- Table: BattlefieldActionsHistory
CREATE TABLE BattlefieldActionsHistory (
    Id integer  NOT NULL,
    ActionDate timestamp  NOT NULL,
    ActionDescription varchar(200)  NOT NULL,
    Battlefield_Id integer  NOT NULL,
    ActionBy_Player_Id varchar(32)  NOT NULL,
    Value int  NOT NULL,
    CONSTRAINT BattlefieldActionsHistory_pk PRIMARY KEY (Id)
);

-- Table: BattlefieldHistory
CREATE TABLE BattlefieldHistory (
    Id integer  NOT NULL,
    FightStartDate timestamp  NOT NULL,
    FightEndDate timestamp  NULL,
    WhoWon_Player_Id varchar(32)  NOT NULL,
    Player1_Id varchar(32)  NOT NULL,
    Player2_Id varchar(32)  NOT NULL,
    CONSTRAINT WhoWon_Check CHECK (( WhoWon_Player_Id in ( Player1_Id , Player2_Id ) )) NOT DEFERRABLE INITIALLY IMMEDIATE,
    CONSTRAINT BattlefieldHistory_pk PRIMARY KEY (Id)
);

-- Table: Item
CREATE TABLE Item (
    Id integer  NOT NULL,
    Name varchar(200)  NOT NULL,
    MaxDurability integer  NOT NULL,
    Price integer  NOT NULL,
    Type varchar(200)  NOT NULL,
    DefDamage integer  NULL,
    Damage integer  NOT NULL,
    HealValue integer  NOT NULL,
    CONSTRAINT CHECK_0 CHECK (( MaxDurability >= 0 )) NOT DEFERRABLE INITIALLY IMMEDIATE,
    CONSTRAINT Item_pk PRIMARY KEY (Id)
);

-- Table: Item_Statistic_XREF
CREATE TABLE Item_Statistic_XREF (
    Item_Id integer  NOT NULL,
    Statistic_Id integer  NOT NULL
);

-- Table: Player
CREATE TABLE Player (
    Id varchar(32)  NOT NULL,
    Nickname varchar(200)  NOT NULL,
    Password varchar(200)  NOT NULL,
    CurrentHp integer  NOT NULL,
    MaxHp integer  NOT NULL,
    CurrentMana integer  NOT NULL,
    MaxMana integer  NOT NULL,
    CreatedAt timestamp  NOT NULL,
    Gold integer  NOT NULL,
    Type varchar(200)  NOT NULL,
    CONSTRAINT CHECK_1 CHECK (( Gold >= 0 )) NOT DEFERRABLE INITIALLY IMMEDIATE,
    CONSTRAINT Player_pk PRIMARY KEY (Id)
);

-- Table: Player_Item_XREF
CREATE TABLE Player_Item_XREF (
    Player_Id varchar(32)  NOT NULL,
    Item_Id integer  NOT NULL,
    CustomItemName varchar(200)  NULL,
    IsEquiped boolean  NOT NULL,
    CurrentDurability integer  NULL
);

-- Table: Statistic
CREATE TABLE Statistic (
    Id integer  NOT NULL,
    StatisticType_Id integer  NOT NULL,
    Value integer  NOT NULL,
    CONSTRAINT Statistic_pk PRIMARY KEY (Id)
);

-- Table: StatisticType
CREATE TABLE StatisticType (
    Id integer  NOT NULL,
    Name varchar(200)  NOT NULL,
    CONSTRAINT StatisticType_pk PRIMARY KEY (Id)
);

-- foreign keys
-- Reference: BfActionsHistory_Bf (table: BattlefieldActionsHistory)
ALTER TABLE BattlefieldActionsHistory ADD CONSTRAINT BfActionsHistory_Bf
    FOREIGN KEY (Battlefield_Id)
    REFERENCES BattlefieldHistory (Id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: BfActionsHistory_Player (table: BattlefieldActionsHistory)
ALTER TABLE BattlefieldActionsHistory ADD CONSTRAINT BfActionsHistory_Player
    FOREIGN KEY (ActionBy_Player_Id)
    REFERENCES Player (Id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Bf_Player1 (table: BattlefieldHistory)
ALTER TABLE BattlefieldHistory ADD CONSTRAINT Bf_Player1
    FOREIGN KEY (Player1_Id)
    REFERENCES Player (Id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Bf_Player2 (table: BattlefieldHistory)
ALTER TABLE BattlefieldHistory ADD CONSTRAINT Bf_Player2
    FOREIGN KEY (Player2_Id)
    REFERENCES Player (Id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Bf_Player_WhoseTurn (table: BattlefieldHistory)
ALTER TABLE BattlefieldHistory ADD CONSTRAINT Bf_Player_WhoseTurn
    FOREIGN KEY (WhoWon_Player_Id)
    REFERENCES Player (Id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Item_Statistic_XREF_Item (table: Item_Statistic_XREF)
ALTER TABLE Item_Statistic_XREF ADD CONSTRAINT Item_Statistic_XREF_Item
    FOREIGN KEY (Item_Id)
    REFERENCES Item (Id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Item_Statistic_XREF_Statistic (table: Item_Statistic_XREF)
ALTER TABLE Item_Statistic_XREF ADD CONSTRAINT Item_Statistic_XREF_Statistic
    FOREIGN KEY (Statistic_Id)
    REFERENCES Statistic (Id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Player_Item_XREF_Item (table: Player_Item_XREF)
ALTER TABLE Player_Item_XREF ADD CONSTRAINT Player_Item_XREF_Item
    FOREIGN KEY (Item_Id)
    REFERENCES Item (Id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Player_Item_XREF_Player (table: Player_Item_XREF)
ALTER TABLE Player_Item_XREF ADD CONSTRAINT Player_Item_XREF_Player
    FOREIGN KEY (Player_Id)
    REFERENCES Player (Id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Statistic_StatisticType (table: Statistic)
ALTER TABLE Statistic ADD CONSTRAINT Statistic_StatisticType
    FOREIGN KEY (StatisticType_Id)
    REFERENCES StatisticType (Id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

