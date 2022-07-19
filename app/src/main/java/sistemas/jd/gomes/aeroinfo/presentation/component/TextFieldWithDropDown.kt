package sistemas.jd.gomes.aeroinfo.presentation.component

import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import sistemas.jd.gomes.aeroinfo.R
import sistemas.jd.gomes.aeroinfo.data.model.Airport
import java.util.ArrayList

@Composable
fun TextFieldWithDropDown(
    items: List<Airport>,
    selectedValue: String?,
    modifier: Modifier = Modifier,
    onSelect: (Int) -> Unit
) {
    var context = LocalContext.current
    AndroidView(
        factory = { context ->
            val autoCompleteTextView = AutoCompleteTextView
                .inflate(context, R.layout.text_input_field, null) as AutoCompleteTextView

//            val adapter =
//                ArrayAdapter(context, R.layout.items, items)

            val adapter = MovieAdapter(context, items.toList() as ArrayList<Airport>?)

            autoCompleteTextView.setAdapter(adapter)
            autoCompleteTextView.setText(selectedValue, false)
            autoCompleteTextView.setOnItemClickListener { _, _, index, _ -> onSelect(index) }
            autoCompleteTextView
        },
        update = { autoCompleteTextView ->
            val adapter = MovieAdapter(context, items.toList() as ArrayList<Airport>?)
            autoCompleteTextView.setAdapter(adapter)
            autoCompleteTextView.setText(selectedValue, false)
        },
        modifier = modifier
    )
}