package sistemas.jd.gomes.aeroinfo.presentation.detail.info

import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import sistemas.jd.gomes.aeroinfo.ui.theme.GrayDark
import sistemas.jd.gomes.aeroinfo.ui.theme.YellowDark
import sistemas.jd.gomes.aeroinfo.R

@Composable
fun DetailScreen() {

}

@Composable
fun TextFieldWithDropDown(
    items: List<String>,
    selectedValue: String?,
    modifier: Modifier = Modifier,
    onSelect: (Int) -> Unit
) {
    AndroidView(
        factory = { context ->
            val autoCompleteTextView = AutoCompleteTextView
                .inflate(context, R.layout.text_input_field, null) as AutoCompleteTextView

            val adapter =
                ArrayAdapter(context, android.R.layout.simple_expandable_list_item_1, items)
            autoCompleteTextView.setAdapter(adapter)
            autoCompleteTextView.setText(selectedValue, false)
            autoCompleteTextView.setOnItemClickListener { _, _, index, _ -> onSelect(index) }
            autoCompleteTextView
        },
        update = { autoCompleteTextView ->
            val adapter = ArrayAdapter(
                autoCompleteTextView.context,
                android.R.layout.simple_list_item_1,
                items
            )
            autoCompleteTextView.setAdapter(adapter)
            autoCompleteTextView.setText(selectedValue, false)
        },
        modifier = modifier
    )
}