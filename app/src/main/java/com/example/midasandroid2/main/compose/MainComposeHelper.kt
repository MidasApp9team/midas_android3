package com.example.midasandroid2.main.compose

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.midasandroid2.R
import com.example.midasandroid2.main.MainActivity
import com.example.midasandroid2.main.MainViewModel
import com.example.midasandroid2.main.compose.SharedHelp.DATE
import com.example.midasandroid2.main.compose.SharedHelp.IN
import com.example.midasandroid2.main.compose.SharedHelp.OUT
import com.example.midasandroid2.main.compose.local.Share
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Stable
private val CommuteHeight: Dp = 42.dp

@DelicateCoroutinesApi
@Composable
fun MainComposeHelper(
    context: MainActivity,
    homeWorking: Boolean = true
){
    var inHour = 0
    var inMin = 0
    var outHour = 0
    var outMin = 0
    var timeSize by remember { mutableStateOf(0) }
    var totalWork by remember { mutableStateOf(0) }
    var inTime by remember { mutableStateOf(Share.getString(context, IN,"")) }
    var outTime by remember { mutableStateOf(Share.getString(context,OUT,"")) }
    var date = Share.getString(context,DATE,"")

    if(date == ""){
        Share.putString(context, DATE, date())
        date = date()
    }

    if(date != date()){
        Share.deleteString(context, IN)
        Share.deleteString(context, OUT)
        inTime = ""
        outTime = ""
    }

    if(inTime.isNotEmpty() && outTime.isEmpty()){
        timeSize = (inTime.substring(0 until 1).toInt() * 60 + inTime.substring(3 until 4).toInt())- (time().substring(0 until 1).toInt() + time().substring(3 until  4).toInt())
        inHour = timeSize/60
        inMin =  timeSize%60
    }

    if(inTime.isNotEmpty() && outTime.isNotEmpty()) {
         timeSize = (outTime.substring(0 until 1).toInt() * 60 + outTime.substring(3 until 4).toInt())- (inTime.substring(0 until 1).toInt() + inTime.substring(3 until  4).toInt())
    }

    val graphStart = inHour+inHour

    var graphWidth by remember { mutableStateOf(inHour+inMin) }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 1.dp)
        .background(
            color = BaseColor.White,
            shape = RoundedCornerShape(40.dp)
        )
        .btnClickable {
            GlobalScope.launch {
                graphWidth = 0
                delay(2000)
                graphWidth = timeSize
            }
        }
    ){
        Column(
            modifier = Modifier
                .padding(horizontal = 22.dp)
        ) {
            Spacer(modifier = Modifier.height(13.dp))

            TopRow()

            Spacer(modifier = Modifier.height(23.dp))

            Commute(inTime = inTime, outTime = outTime, homeWorking = homeWorking)

            Spacer(modifier = Modifier.height(16.dp))

            Row() {
                Body2(text = stringResource(id = R.string.total_work_time))

                Body2(
                    text = totalWork.toString()+"분",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Graph(graphStart = graphStart, graphWidth = graphWidth)

            Spacer(modifier = Modifier.height(30.dp))
            
            Row() {
                PurpleBtn(
                    text = stringResource(id = R.string.`in`)
                ){
                    if(inTime.isEmpty()){
                        inTime = time()
                        Share.putString(context, IN, time())
                    }
                }

                PurpleBtn(
                    text = stringResource(id = R.string.out),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                ) {
                    if(inTime.isNotEmpty()){
                        if(outTime.isEmpty()){
                            outTime = time()
                            totalWork = timeSize
                            Share.putString(context, OUT, time())
                        }
                    }
                }
            }
        }
    }
}

@Stable
private val TopRowHeight: Dp = 36.dp

@Composable
fun TopRow() {
    Row(modifier = Modifier
        .height(TopRowHeight)
    ) {
        Body1(text = stringResource(id = R.string.commute_now))

        Spacer(modifier = Modifier.width(5.dp))

        Body2(
            text = stringResource(id = R.string.today),
            color = BaseColor.Black40,
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentHeight(Alignment.Bottom)
        )
    }
}



@Composable
fun Commute(
    inTime: String,
    outTime: String,
    homeWorking: Boolean
){
    val inTime = inTime.ifEmpty { "xx:xx" }
    val outTime = outTime.ifEmpty { "xx:xx" }

    Row(
        modifier = Modifier
            .height(CommuteHeight)
    ) {
        Column() {
            Body2(
                text = stringResource(id = R.string.in_time)
                        + "   "
                        + inTime,
                color = BaseColor.LightGreen
            )

            Body2(
                text = stringResource(id = R.string.out_time)
                        + "   "
                        + outTime,
                color = BaseColor.Red,
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentHeight(Alignment.Bottom)
            )
        }

        if (homeWorking) {
            Body1(
                text = stringResource(id = R.string.home_working),
                color = BaseColor.LightGreen,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(Alignment.CenterVertically)
                    .wrapContentWidth(Alignment.End)
            )
        }
    }
}

@Stable
private val GraphWidth: Dp = 360.dp

@Stable
private val GraphHeight: Dp = 30.dp

@Stable
private val GraphCornerShape: Dp = 4.dp

@Stable
private val GraphAnimationTween: Int = 2000

@Composable
fun Graph(
    graphStart: Int,
    graphWidth: Int,
) {

    val graphColor = if(graphWidth >= 480) BaseColor.LightGreen else BaseColor.Red

    val animationProgress: Float by animateFloatAsState(
        targetValue = (graphWidth / 4).toFloat(),
        tween(GraphAnimationTween)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .width(GraphWidth)
            .height(GraphHeight)
            .background(
                color = BaseColor.Gray,
                shape = RoundedCornerShape(GraphCornerShape)
            )
    ){
        Box(
            modifier = Modifier
                .padding(start = graphStart.dp)
                .width(animationProgress.toInt().dp)
                .fillMaxHeight()
                .background(
                    color = graphColor
                )
        )
    }
}

@Stable
private val PurpleBtnWidth: Dp = 100.dp

@Stable
private val PurpleBtnHeight: Dp = 50.dp

@Stable
private val PurpleBtnCornerShape: Dp = 30.dp

@Composable
fun PurpleBtn(
    modifier: Modifier = Modifier,
    text: String,
    onClick: (() -> Unit)?
){
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState()

    val btnColor =
        if(isPressed.value) BaseColor.MainPurple else BaseColor.SubPurple

    Box(
        modifier = modifier
            .width(PurpleBtnWidth)
            .height(PurpleBtnHeight)
            .background(
                color = btnColor,
                shape = RoundedCornerShape(PurpleBtnCornerShape)
            )
            .btnClickable(
                rippleColor = btnColor,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        BtnBody(text = text)
    }
}

object SharedHelp{
    const val IN = "IN"
    const val OUT = "OUT"
    const val DATE = "DATE"
}