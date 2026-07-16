package com.example.runWave.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.runWave.R
import com.example.runWave.ui.theme.RunYellow

@Composable
fun TermsAndServicesText() {
    val fullText = stringResource(R.string.Terms_and_Services)
    val tosPart = "Terms of Service"
    val ppPart = "Privacy Policy"

    val annotatedString = buildAnnotatedString {
        val tosIndex = fullText.indexOf(tosPart)
        val ppIndex = fullText.indexOf(ppPart)

        if (tosIndex != -1 && ppIndex != -1) {
            append(fullText.substring(0, tosIndex))
            withLink(LinkAnnotation.Clickable("tos") { /* Open TOS */ }) {
                withStyle(SpanStyle(fontWeight = FontWeight.SemiBold, color = RunYellow)) {
                    append(tosPart)
                }
            }
            append(fullText.substring(tosIndex + tosPart.length, ppIndex))
            withLink(LinkAnnotation.Clickable("pp") { /* Open Privacy Policy */ }) {
                withStyle(SpanStyle(fontWeight = FontWeight.SemiBold, color = RunYellow)) {
                    append(ppPart)
                }
            }
            append(fullText.substring(ppIndex + ppPart.length))
        } else {
            append(fullText)
        }
    }

    Text(
        text = annotatedString,
        color = Color.Gray,
        textAlign = TextAlign.Center,
        fontSize = 13.sp,
        modifier = Modifier.fillMaxWidth()
    )
}