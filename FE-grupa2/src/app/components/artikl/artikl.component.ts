import { Component } from '@angular/core';
import { Subscription } from 'rxjs';
import { Artikl } from 'src/app/models/artikl';
import { ArtiklService } from 'src/app/services/artikl.service';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-artikl',
  templateUrl: './artikl.component.html',
  styleUrls: ['./artikl.component.css']
})
export class ArtiklComponent {
  subscription!: Subscription;
  displayedColumns = ['id', 'naziv', 'proizvodjaca', 'actions'];
  dataSource!: MatTableDataSource<Artikl>;
  
  constructor(private artiklService: ArtiklService) { }

  ngOnInit(): void { this.loadData(); }

  public loadData() {
    this.subscription = this.artiklService.getAllArtikli().subscribe(
      data => {
        //console.log(data);
        this.dataSource = new MatTableDataSource(data);
      },
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
      }
    );
  }
}
