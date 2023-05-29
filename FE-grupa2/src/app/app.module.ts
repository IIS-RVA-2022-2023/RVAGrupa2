import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ArtiklComponent } from './components/artikl/artikl.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatExpansionModule } from '@angular/material/expansion';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTableModule } from '@angular/material/table';
import { MatDialogModule } from '@angular/material/dialog';
import { ArtiklDialogComponent } from './components/dialogs/artikl-dialog/artikl-dialog.component';
import { DobavljacDialogComponent } from './components/dialogs/dobavljac-dialog/dobavljac-dialog.component';
import { PorudzbinaDialogComponent } from './components/dialogs/porudzbina-dialog/porudzbina-dialog.component';
import { StavkaPorudzbineDialogComponent } from './components/dialogs/stavka-porudzbine-dialog/stavka-porudzbine-dialog.component';
import { DobavljacComponent } from './components/dobavljac/dobavljac.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatSelectModule } from '@angular/material/select';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';
import { PorudzbinaComponent } from './components/porudzbina/porudzbina.component';
import { StavkaPorudzbineComponent } from './components/stavka-porudzbine/stavka-porudzbine.component';

@NgModule({
  declarations: [
    AppComponent,
    ArtiklComponent,
    ArtiklDialogComponent,
    DobavljacDialogComponent,
    PorudzbinaDialogComponent,
    StavkaPorudzbineDialogComponent,
    DobavljacComponent,
    PorudzbinaComponent,
    StavkaPorudzbineComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule,
    MatSidenavModule, 
    MatListModule,
    MatGridListModule,
    MatExpansionModule,
    HttpClientModule,
    MatToolbarModule,
    MatSnackBarModule,
    MatTableModule,
    MatDialogModule,
    MatFormFieldModule,
    FormsModule,
    MatInputModule,
    MatDatepickerModule,
    MatCheckboxModule,
    MatSelectModule,
    MatNativeDateModule,
    MatSortModule,
    MatPaginatorModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
