package com.haiso.commons.utils.menu;

/**
 * Created by ff on 6/18/14.
 */
public class MenuHelper {
    /*public MenuNode getMenuNode(List<Resources> resourcesList){
        MenuNode rootMenu = new MenuNode("0", "MENU", "root menu", "root menu", false, (short)0, null);
        List<Resources> l1list = new ArrayList<Resources>();
        List<Resources> l2list = new ArrayList<Resources>();
        List<Resources> l3list = new ArrayList<Resources>();
        List<Resources> l4list = new ArrayList<Resources>();
        for(Iterator<Resources> it = resourcesList.iterator(); it.hasNext(); ){
            Resources res = it.next();
            switch(res.getLevel()){
                case (short)1:
                    l1list.add(res);
                    break;
                case (short)2:
                    l2list.add(res);
                    break;
                case (short)3:
                    l3list.add(res);
                    break;
                case (short)4:
                    l4list.add(res);
                    break;
                default:
                    break;
            }
        }
        //String menuSn, String name, String desc, String tips, Boolean isSub, Short level, Set<MenuNode> submenu
        Set<MenuNode> menu1 = new HashSet<MenuNode>();
        for(Iterator<Resources> it = l1list.iterator(); it.hasNext(); ){
            Resources res = it.next();
            menu1.add(new MenuNode("0" + res.getId().toString(),res.getName(),res.getDesc(), res.getTips(), res.getIsChild(), res.getLevel(), null));
        }
        Set<MenuNode> menu2 = new HashSet<MenuNode>();
        for(Iterator<Resources> it = l2list.iterator(); it.hasNext(); ){
            Resources res = it.next();
            for(Iterator<MenuNode> it1 = menu1.iterator(); it1.hasNext(); ){
                MenuNode m1 = it1.next();
                if(("0" + res.getId().equals(m1.getMenuSn())){
                    m1.getSubmenu().add(new MenuNode());
                }
            }
            menu2.add(new MenuNode());
        }
        Set<MenuNode> menu3 = new HashSet<MenuNode>();
        for(Iterator<Resources> it = l3list.iterator(); it.hasNext(); ){
            Resources res = it.next();
            menu3.add(new MenuNode());
        }
        Set<MenuNode> menu4 = new HashSet<MenuNode>();
        for(Iterator<Resources> it = l4list.iterator(); it.hasNext(); ){
            Resources res = it.next();
            menu4.add(new MenuNode());
        }

        return rootMenu;
    }*/
}
