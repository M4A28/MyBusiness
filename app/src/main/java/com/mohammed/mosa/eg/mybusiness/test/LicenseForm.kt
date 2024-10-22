package com.mohammed.mosa.eg.mybusiness.test
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mohammed.mosa.eg.mybusiness.data.module.License
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
class LicenseFormState {
    var licenseOrRecordNumber by mutableStateOf("")
    var ownerName by mutableStateOf("")
    var ownerId by mutableStateOf("")
    var idOrRecordNumber by mutableStateOf("")
    var activity by mutableStateOf("")
    var classification by mutableStateOf("")
    var expiryDate by mutableStateOf(LocalDateTime.now())
    var municipality by mutableStateOf("")
    var localMunicipality by mutableStateOf("")
    var licenseType by mutableStateOf("")
}

data class LicenseFormError(
    val licenseOrRecordNumber: String? = null,
    val ownerName: String? = null,
    val ownerId: String? = null,
    val idOrRecordNumber: String? = null,
    val activity: String? = null,
    val classification: String? = null,
    val expiryDate: String? = null,
    val municipality: String? = null,
    val localMunicipality: String? = null,
    val licenseType: String? = null
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LicenseForm(
    onSubmit: (License) -> Unit,
    modifier: Modifier = Modifier
) {
    val formState = remember { LicenseFormState() }
    var formError by remember { mutableStateOf(LicenseFormError()) }
    var showDatePicker by remember { mutableStateOf(false) }
    var showErrorDialog by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    val dateFormatter = remember { DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // License Details Section
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "License Details",
                    style = MaterialTheme.typography.titleMedium
                )

                OutlinedTextField(
                    value = formState.licenseOrRecordNumber,
                    onValueChange = { formState.licenseOrRecordNumber = it },
                    label = { Text("License/Record Number") },
                    isError = formError.licenseOrRecordNumber != null,
                    supportingText = { formError.licenseOrRecordNumber?.let { Text(it) } },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = formState.ownerName,
                    onValueChange = { formState.ownerName = it },
                    label = { Text("Owner Name") },
                    isError = formError.ownerName != null,
                    supportingText = { formError.ownerName?.let { Text(it) } },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = formState.ownerId,
                    onValueChange = { formState.ownerId = it },
                    label = { Text("Owner ID") },
                    isError = formError.ownerId != null,
                    supportingText = { formError.ownerId?.let { Text(it) } },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // Business Details Section
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Business Details",
                    style = MaterialTheme.typography.titleMedium
                )

                OutlinedTextField(
                    value = formState.activity,
                    onValueChange = { formState.activity = it },
                    label = { Text("Activity") },
                    isError = formError.activity != null,
                    supportingText = { formError.activity?.let { Text(it) } },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = formState.classification,
                    onValueChange = { formState.classification = it },
                    label = { Text("Classification") },
                    isError = formError.classification != null,
                    supportingText = { formError.classification?.let { Text(it) } },
                    modifier = Modifier.fillMaxWidth()
                )

                // Date Field
                OutlinedTextField(
                    value = formState.expiryDate.format(dateFormatter),
                    onValueChange = { },
                    label = { Text("Expiry Date") },
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { showDatePicker = true },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Select date"
                        )
                    }
                )
            }
        }

        // Location Details Section
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Location Details",
                    style = MaterialTheme.typography.titleMedium
                )

                OutlinedTextField(
                    value = formState.municipality,
                    onValueChange = { formState.municipality = it },
                    label = { Text("Municipality") },
                    isError = formError.municipality != null,
                    supportingText = { formError.municipality?.let { Text(it) } },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = formState.localMunicipality,
                    onValueChange = { formState.localMunicipality = it },
                    label = { Text("Local Municipality") },
                    isError = formError.localMunicipality != null,
                    supportingText = { formError.localMunicipality?.let { Text(it) } },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = formState.licenseType,
                    onValueChange = { formState.licenseType = it },
                    label = { Text("License Type") },
                    isError = formError.licenseType != null,
                    supportingText = { formError.licenseType?.let { Text(it) } },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Button(
            onClick = {
                validateAndSubmit(formState, onSubmit) { error ->
                    errorMessage = error
                    showErrorDialog = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit License Application")
        }
    }

    // Date Picker Dialog
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(onClick = {
                    showDatePicker = false
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showDatePicker = false
                }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(
                onDateSelected = { millis ->
                    val selectedDate = LocalDateTime.now() // Convert millis to LocalDateTime
                    formState.expiryDate = selectedDate
                    showDatePicker = false
                }
            )
        }
    }

    // Error Dialog
    if (showErrorDialog) {
        AlertDialog(
            onDismissRequest = { showErrorDialog = false },
            title = { Text("Error") },
            text = { Text(errorMessage) },
            confirmButton = {
                TextButton(onClick = { showErrorDialog = false }) {
                    Text("OK")
                }
            }
        )
    }
}

private fun validateAndSubmit(
    formState: LicenseFormState,
    onSubmit: (License) -> Unit,
    onError: (String) -> Unit
) {
    // Validation
    val errors = mutableListOf<String>()

    if (formState.licenseOrRecordNumber.isBlank()) errors.add("License number is required")
    if (formState.ownerName.isBlank()) errors.add("Owner name is required")
    if (formState.ownerId.isBlank()) errors.add("Owner ID is required")
    if (formState.activity.isBlank()) errors.add("Activity is required")
    if (formState.classification.isBlank()) errors.add("Classification is required")
    if (formState.municipality.isBlank()) errors.add("Municipality is required")
    if (formState.localMunicipality.isBlank()) errors.add("Local municipality is required")
    if (formState.licenseType.isBlank()) errors.add("License type is required")

    if (errors.isNotEmpty()) {
        onError(errors.joinToString("\n"))
        return
    }

    try {
        val license = License(
            licenseOrRecordNumber = formState.licenseOrRecordNumber,
            ownerName = formState.ownerName,
            ownerId = formState.ownerId,
            idOrRecordNumber = formState.idOrRecordNumber,
            activity = formState.activity,
            classification = formState.classification,
            expiryDate = formState.expiryDate,
            municipality = formState.municipality,
            localMunicipality = formState.localMunicipality,
            licenseType = formState.licenseType
        )
        onSubmit(license)
    } catch (e: Exception) {
        onError("An error occurred: ${e.message}")
    }
}

// DatePicker composable
@Composable
fun DatePicker(
    onDateSelected: (Long) -> Unit
) {
    // Implementation of custom date picker UI
    // You can use CalendarView or create your own calendar UI
    // For simplicity, we'll just show a basic implementation
    Column {
        // Simple date selection UI
        Text("Select a date")
        // Add your date selection implementation here
    }
}