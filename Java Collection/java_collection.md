Nama    : Dimas Yoga Pratama
NIM     : 235150700111022

# JAVA COLLECTION

## Pengenalan Collection

- Collection adalah fungsi dalam bahasa pemrograman yang disebut sebagai container yang mengumpulkan data yang mirip dengan Array.
- Java menyediakan class-class collection yang bisa langsung digunakan tanpa tambahan library.

## Iterable & Iterator Interface

- Iterable adalah parent untuk semua collection di Java, kecuali Map, digunakan agar mendukung for-each loop.
- Iterator mendefinisikan cara mengakses element di collection secara sequential.

## Collection Interface

- Collection merupakan kontrak untuk memanipulasi data collection, seperti menambah, menghapus, dan mengecek isi data collection.
- Tidak ada direct implementation untuk Collection, karena akan dibagi lagi menjadi List, Set, dan Queue.

## List Interface

- List adalah struktur data collection yang bisa memiliki elemen duplikat, berurut sesuai dengan posisi, dan memiliki index.

## Queue Interface

- Queue adalah implementasi dari struktur data antrian atau FIFO (First In First Out).

## Deque Interface

- Deque adalah implementasi struktur data antrian dan stack (LIFO) yang bisa beroperasi dari depan atau belakang.

## Map Interface

- Map adalah struktur data collection yang berisikan mapping antara key dan value, dimana key harus unik.
- HashMap adalah implementasi Map yang melakukan distribusi key menggunakan hashCode() function.