package net.chiappone.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author Kurtis Chiappone
 * @date 10/9/2016
 */
public class ByteUtil {

	private static final Logger logger = LoggerFactory.getLogger( ByteUtil.class );

	/**
	 * @param obj
	 * @return
	 * @throws IOException
	 */
	public static byte[] toByteArray( Object obj ) {

		byte[] sendBuf = null;
		ObjectOutputStream os = null;

		try {

			ByteArrayOutputStream byteStream = new ByteArrayOutputStream( 5000 );
			os = new ObjectOutputStream( new BufferedOutputStream( byteStream ) );
			os.flush();
			os.writeObject( obj );
			os.flush();
			sendBuf = byteStream.toByteArray();

		} catch ( IOException e ) {

			logger.error( "Error converting object to byte array", e );

		} finally {

			if ( os != null ) {

				try {

					os.close();

				} catch ( Exception e ) {

					logger.debug( "Error closing object output stream", e );

				}

			}

		}

		return sendBuf;

	}

}
