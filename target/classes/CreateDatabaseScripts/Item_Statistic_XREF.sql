--Kazdy item ma po 2 losowe statystyki
insert into Item_Statistic_XREF (Item_Id, Statistic_Id)
select i.Id, floor(dbms_random.value(1,9)) from Item i;


insert into Item_Statistic_XREF (Item_Id, Statistic_Id)
select i.Id, floor(dbms_random.value(1,9)) from Item i;
