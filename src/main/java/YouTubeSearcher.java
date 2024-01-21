import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import org.jetbrains.annotations.NotNull;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class YouTubeSearcher extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Editor editor = event.getData(PlatformDataKeys.EDITOR);

        assert editor != null;
        String selectedText = editor.getSelectionModel().getSelectedText();

        System.out.println(selectedText);

        if (selectedText == null){

            BrowserUtil.browse("https://www.youtube.com/watch?v=_e9yMqmXWo0");
        } else{
            String encoded = URLEncoder.encode(selectedText, StandardCharsets.UTF_8);

            String address = String.format("https://www.youtube.com/results?search_query=%s", encoded);

            BrowserUtil.browse(address);
        }
    }
}
