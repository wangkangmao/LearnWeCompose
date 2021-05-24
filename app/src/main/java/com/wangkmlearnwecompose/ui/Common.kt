package com.wangkmlearnwecompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.wangkmlearnwecompose.ui.theme.WeTheme
import com.wangkmlearnwecompose.R
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding

/**
 * @author: created by wangkm
 * @time: 2021/05/23 22:35
 * @desc：use common ui
 * @email: 1240413544@qq.com
 */

@Composable
fun WeTopBar(title:String,onBack: (() -> Unit)? = null) {
    Box (
        Modifier
            .background(WeTheme.colors.background)
            .fillMaxWidth()
            .statusBarsPadding()
            ){
        Row(
            Modifier
                .height(48.dp)
        ) {
            if(onBack !=null){
                Icon(
                   painterResource(R.drawable.ic_back),
                    null,
                    Modifier
                        .clickable { onBack }
                        .align(Alignment.CenterVertically)
                        .size(36.dp)
                        .padding(8.dp),
                    tint = WeTheme.colors.icon
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            // todo WeViewModel
//            val viewModel:WeV
            Icon(painter = painterResource(id = R.drawable.ic_palette)
                , contentDescription = "切换主题",
                Modifier
                    .clickable(onClick = {
                        // todo choose theme
                    })
                    .align(Alignment.CenterVertically)
                    .size(36.dp)
                    .padding(8.dp),
                tint = WeTheme.colors.icon
            )
        }
        Text(title,Modifier.align(Alignment.Center),color = WeTheme.colors.textPrimary)
    }

}

@Composable
fun WeBottomBar(modifier: Modifier = Modifier, content: @Composable RowScope.() -> Unit) {

    Row(
        modifier
            .fillMaxWidth()
            .background(WeTheme.colors.bottomBar)
            .padding(4.dp, 0.dp)
            .navigationBarsPadding(),
        content = content
    )


}