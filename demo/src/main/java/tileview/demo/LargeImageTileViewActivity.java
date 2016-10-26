package tileview.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.qozix.tileview.TileView;
import com.qozix.tileview.hotspots.HotSpot;
import com.qozix.tileview.widgets.ZoomPanLayout;

public class LargeImageTileViewActivity extends TileViewActivity {

	@Override
	public void onCreate( Bundle savedInstanceState ) {
		
		super.onCreate( savedInstanceState );
		
		// multiple references
		final TileView tileView = getTileView();

		// size of original image at 100% mScale
		// but made short to better demonstrate the size of the MarkerLayout
		tileView.setSize( 2835, 3000 );

		tileView.setMinimumScaleMode( ZoomPanLayout.MinimumScaleMode.FIT );

		tileView.addHotSpot( createHotSpot( 2835, 3000 ) );

		// detail levels
		tileView.addDetailLevel( 1.000f, "tiles/painting/1000/%d_%d.jpg");
		tileView.addDetailLevel( 0.500f, "tiles/painting/500/%d_%d.jpg");
		tileView.addDetailLevel( 0.250f, "tiles/painting/250/%d_%d.jpg");
		tileView.addDetailLevel( 0.125f, "tiles/painting/125/%d_%d.jpg");
		
		// set mScale to 0, but keep scaleToFit true, so it'll be as small as possible but still match the container
		tileView.setScale( 0 );
		
		// render while panning
		tileView.setShouldRenderWhilePanning( true );

		// disallow going back to minimum scale while double-taping at maximum scale (for demo purpose)
		tileView.setShouldLoopScale( false );
	}

	private HotSpot createHotSpot( int width, int height ) {
		HotSpot hotSpot = new HotSpot();
		hotSpot.setHotSpotTapListener( new HotSpot.HotSpotTapListener() {
			@Override
			public void onHotSpotTap( HotSpot hotSpot, int x, int y ) {
				getTileView().addCallout( createCallOut(), x / getTileView().getScale(), y / getTileView().getScale(), -0.5f, -1f );
			}
		} );

		hotSpot.set( 0, 0, width, height );
		return hotSpot;
	}

	private View createCallOut() {
		View v = ((LayoutInflater) getSystemService( LAYOUT_INFLATER_SERVICE )).inflate( R.layout.callout, null );
		v.findViewById( R.id.btn ).setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick( View v ) {
				Toast.makeText( LargeImageTileViewActivity.this, "tapped button", Toast.LENGTH_SHORT ).show();
			}
		} );
		return v;
	}
}
