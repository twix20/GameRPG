-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-01-07 12:27:44.296

-- tables
-- Table: BattlefieldActionsHistory
CREATE TABLE BattlefieldActionsHistory (
    Id serial  NOT NULL,
    ActionDate timestamp  NOT NULL,
    ActionDescription varchar(200)  NOT NULL,
    Value int  NOT NULL,
    Battlefield_Id int  NOT NULL,
    ActionBy_Player_Id int  NOT NULL,
    CONSTRAINT BattlefieldActionsHistory_pk PRIMARY KEY (Id)
);

-- Table: BattlefieldHistory
CREATE TABLE BattlefieldHistory (
    Id serial  NOT NULL,
    FightStartDate timestamp  NOT NULL,
    FightEndDate timestamp  NULL,
    WhoWon_Player_Id int  NOT NULL,
    Player1_Id int  NOT NULL,
    Player2_Id int  NOT NULL,
    CONSTRAINT WhoWon_Check CHECK (( ( WhoWon_Player_Id in ( Player1_Id , Player2_Id ) ) )) NOT DEFERRABLE INITIALLY IMMEDIATE,
    CONSTRAINT BattlefieldHistory_pk PRIMARY KEY (Id)
);

-- Table: Item
CREATE TABLE Item (
    Id serial  NOT NULL,
    Name varchar(200)  NOT NULL,
    MaxDurability int  NOT NULL,
    Price int  NOT NULL,
    Type varchar(200)  NOT NULL,
    DefDamage int  NULL,
    Damage int  NULL,
    HealValue int  NULL,
    CONSTRAINT CHECK_0 CHECK (( ( MaxDurability >= 0 ) )) NOT DEFERRABLE INITIALLY IMMEDIATE,
    CONSTRAINT Item_pk PRIMARY KEY (Id)
);

-- Table: Item_Statistic_XREF
CREATE TABLE Item_Statistic_XREF (
    Item_Id int  NOT NULL,
    Statistic_Id int  NOT NULL
);

-- Table: Player
CREATE TABLE Player (
    Id serial  NOT NULL,
    Nickname varchar(200)  NOT NULL,
    Password varchar(200)  NOT NULL,
    CurrentHp int  NOT NULL,
    MaxHp int  NOT NULL,
    CurrentMana int  NULL,
    MaxMana int  NULL,
    CreatedAt timestamp  NOT NULL,
    Gold int  NOT NULL,
    Type varchar(200)  NOT NULL,
    CONSTRAINT CHECK_0 CHECK (( ( Gold >= 0 ) )) NOT DEFERRABLE INITIALLY IMMEDIATE,
    CONSTRAINT Player_pk PRIMARY KEY (Id)
);

-- Table: Player_Item_XREF
CREATE TABLE Player_Item_XREF (
    Player_Id int  NOT NULL,
    Item_Id int  NOT NULL,
    CustomItemName varchar(200)  NULL,
    IsEquiped boolean  NOT NULL,
    CurrentDurability int  NULL
);

-- Table: Statistic
CREATE TABLE Statistic (
    Id serial  NOT NULL,
    StatisticType_Id int  NOT NULL,
    Value int  NOT NULL,
    CONSTRAINT Statistic_pk PRIMARY KEY (Id)
);

-- Table: StatisticType
CREATE TABLE StatisticType (
    Id serial  NOT NULL,
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

