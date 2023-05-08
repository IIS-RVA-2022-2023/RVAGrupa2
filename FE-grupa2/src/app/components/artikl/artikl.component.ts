import { Component } from '@angular/core';
import { ArtiklService } from 'src/app/services/artikl.service';

@Component({
  selector: 'app-artikl',
  templateUrl: './artikl.component.html',
  styleUrls: ['./artikl.component.css']
})
export class ArtiklComponent {
  constructor(private artiklService: ArtiklService) { }

  ngOnInit():void{
    this.artiklService.getAllArtikli().subscribe(data => {console.log(data)});
  }
}
