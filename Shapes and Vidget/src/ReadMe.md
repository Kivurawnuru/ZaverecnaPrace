# Závěrečná práce z programování
## Shapes and Vidget
Na začátku programu se hráči načte základní postava.
Tento program je vystvěn na UserInterfacu, který má několik možností výběru.
Ve výberu jsou možnosti výpis postavy, boj, challenge mode, upgrade a konec.
### Výpis postavy
Jak už to vyplívá z názvu tak výpis postavy vypíše postavu. Avšak když má 
hráč dost vzkušeností tak se mu nabídnne možnost level uppu, a když s ní 
souhlasí tak se mu zvíší levely v zavislosti na jeho vzkušenostech (exp).
### Boj
#### Popis pro uživatele
Další možnost ve výběru je boj. V boj proti sobě bojují dvě postavy a to hrdina a 
náhodně vybraná postava uložená v ArrayListu nepřátel. Postava může mít jak vyšší
level a schopnosti tak jich může mít znatelně méně. V závislosti na tom, že boj je ze
začátku hry slabší formou Challenge Modu, tak má i menší vzkušenostní odměnu. Vpřipadě
však že vybraný mepřítel má vyšší level tak na to je program taky připraven a dá hráči
(v případě výhry) větší vzkušenostní odměnu.
#### Popis z pohledu programu
Celý boj je vytvořen jako statická metoda, do které se zezačátku pošlu hrdina a jeho 
nepřítel. Ti si v průběhu ciklu uděkují poškození v závislosti na jejich povolání,
rase,štěsí a atributů. Cyklus probíhá tak dlouho dokud se jedna z postav nedostane s 
životy na nulu. Na konci hry jsou hrdinovi a jeho nepříteli obnoveny životy.
### Challenge Mode
Challenge Mode je těžší forma boje.Na začátku Challange mudu se vždy vypíšou informace 
o vyžším boji a jeho chování (pravidla). Celkový výběr nepřítel nezavisí va postavách v 
ArrayListu ale na metodě, která si z ArrayListu načte pouze jméno nově generované 
postavy. Zbytek atributů je Randomem vygenerován v závislosti na levelu hrdiny, což
však stále nezaručuje přiměřeně silného nepřítele. A samozřejmě proto že tohle je Challenge
Mode tak tu hrdina má možnost získání lepšího vzkušenostního ohodnocení.
### Upgrade
Upgrade je možnost, která přesměruje hráče do dalšího UserInterfacu ve kterém má hráč
možnost vylepšit si sílu, inteligenci, obratnost a odolnost pomocí vzkušenostních bodů
takzvaných ,,skillpointů''.Jednotlivé upgrady fungují ve for cyklu. Vždy při výběru nějaké
možnoisti výběru hráče program zkontroluje jestli má hráč dostatek skillpointů, v případě
že má tak ho program pusí dál a nechá mu vzbrat kolik chce použít vzkušenostních bodů na 
upgrade jednotlivých atributů. Jeden skillpoint hráči zvíší atribut o 0,5 bodu. Po zvíšení
artibutu se hráči odečte jeden skillpoint.
### Konec
Možnost konec hráči ukončí hru a uloží stávající hodnoty jeho postavy. Pomocí 
BufferedWriteru přepíšeme hodnoty uživatelovi postavy na hodnoty, které zvýšil v průběhu 
jeho hry a pak se program finálně ukončí.
