import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagenes',
})
export class ImagenesPipe implements PipeTransform {
  transform(prioridad: number): string {
    switch (prioridad) {
      case 1:
        return 'https://img.icons8.com/color/1200/low-priority.jpg';
      case 2:
        return 'https://img.icons8.com/color/1200/medium-priority.jpg';
      case 3:
        return 'https://img.icons8.com/color/1200/high-priority.jpg';
      default:
        return '';
    }
  }
}
