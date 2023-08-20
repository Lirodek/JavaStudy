package org.GamePlayer.Model;

interface INIT_MENU {
	int INPUT=1,STAT=2,PRO=3,MODI=4,PROT=5,EXIT=6;
}
interface MODI_MENU{
	int DELET=1, MODI=2;
}
interface GAMEDATA_MENU{
	int ZERG=1,PROTOSS=2,TERRAN=3,TRIBE=4;
}

interface TRIBE_MENU{
	int ZERG=1,PROTOSS=2,TERRAN=3;
}
interface TRIBE_VAL{
	String ZERG="저그",PROTOSS="플토",TERRAN="테란";
	
}