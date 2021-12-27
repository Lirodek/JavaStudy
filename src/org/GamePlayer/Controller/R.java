package org.GamePlayer.Controller;

import org.GamePlayer.GamerView.GameViewInputData;
import org.GamePlayer.GamerView.GamerTribeView;
import org.GamePlayer.GamerView.GamerView;
import org.GamePlayer.GamerView.GamerViewDelete;
import org.GamePlayer.GamerView.GamerViewListView;
import org.GamePlayer.GamerView.GamerViewMenu;
import org.GamePlayer.GamerView.GamerViewModi;
import org.GamePlayer.GamerView.GamerViewSearchdata;
import org.GamePlayer.Model.GammerVo;

public class R {
	public static int choice;
	public static GammerVo gameVo;
	public static GammerVo[] gameArr;
	public static final int SEARCH=0,GOING=1;
	public static int type=0;
	public static final GamerView searchView= new GamerViewSearchdata();
	public static final GamerView menuView = new GamerViewMenu();
	public static final GamerView inputView = new GameViewInputData();
	public static final GamerView deleteView = new GamerViewDelete();
	public static final GamerView modiView = new GamerViewModi();
	public static final GamerView listView = new GamerViewListView();
	public static final GamerView tribeView = new GamerTribeView();
	public static final GameControl gc = new GameControl();

	
}
