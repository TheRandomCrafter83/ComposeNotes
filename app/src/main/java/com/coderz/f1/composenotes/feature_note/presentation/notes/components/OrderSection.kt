package com.coderz.f1.composenotes.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.coderz.f1.composenotes.feature_note.domain.util.NoteOrder
import com.coderz.f1.composenotes.feature_note.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
){
    Column(modifier= modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(
                //NOTE: if ::class.toString does not work, change back to Title....
                text = NoteOrder.Title::class.java.simpleName,
                selected = noteOrder is NoteOrder.Title,
                onClick = {onOrderChange(NoteOrder.Title(noteOrder.orderType))}
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                //NOTE: if ::class.toString does not work, change back to Date....
                text = NoteOrder.Date::class.java.simpleName,
                selected = noteOrder is NoteOrder.Date,
                onClick = { onOrderChange(NoteOrder.Date(noteOrder.orderType)) })
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                //NOTE: if ::class.toString does not work, change back to Color....
                text = NoteOrder.Color::class.java.simpleName,
                selected = noteOrder is NoteOrder.Color,
                onClick = {onOrderChange(NoteOrder.Color(noteOrder.orderType))})
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(
                //NOTE: if ::class.toString does not work, change back to Ascending....
                text = OrderType.Ascending::class.java.simpleName,
                selected = noteOrder.orderType is OrderType.Ascending,
                onClick = {
                    onOrderChange(
                        noteOrder.copy(OrderType.Ascending)
                    )
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                //NOTE: if ::class.toString does not work, change back to Descending....
                text = OrderType.Descending::class.java.simpleName,
                selected = noteOrder.orderType is OrderType.Descending,
                onClick = {
                    onOrderChange(
                        noteOrder.copy(OrderType.Descending)
                    )
                }
            )
        }
    }
}