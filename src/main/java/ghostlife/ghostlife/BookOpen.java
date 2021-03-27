package ghostlife.ghostlife;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import java.util.List;

public class BookOpen implements Listener {

    private final ghostlife plugin;

    public BookOpen(ghostlife ghostlife){
        this.plugin = ghostlife;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        ItemStack itemStack = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta bookMeta = (BookMeta) itemStack.getItemMeta();
        List<String> Page = plugin.getConfig().getStringList("Update.List");
        for (String s : Page) {
            bookMeta.addPage(s);
        }
        bookMeta.setTitle("Blank");
        bookMeta.setAuthor("Blank");
        itemStack.setItemMeta(bookMeta);
        player.openBook(itemStack);
    }
}
