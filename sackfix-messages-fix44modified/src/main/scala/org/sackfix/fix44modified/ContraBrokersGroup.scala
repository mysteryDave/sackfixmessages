package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class ContraBrokersGroup(contraBrokerField:Option[ContraBrokerField]=None,
                              contraTraderField:Option[ContraTraderField]=None,
                              contraTradeQtyField:Option[ContraTradeQtyField]=None,
                              contraTradeTimeField:Option[ContraTradeTimeField]=None,
                              contraLegRefIDField:Option[ContraLegRefIDField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    contraBrokerField.foreach(fmt(b,_))
    contraTraderField.foreach(fmt(b,_))
    contraTradeQtyField.foreach(fmt(b,_))
    contraTradeTimeField.foreach(fmt(b,_))
    contraLegRefIDField.foreach(fmt(b,_))
    b
  }

}
     
object ContraBrokersGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    ContraBrokerField.TagId, ContraTraderField.TagId, ContraTradeQtyField.TagId, ContraTradeTimeField.TagId, ContraLegRefIDField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ContraBrokerField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[ContraBrokersGroup]=ArrayBuffer.empty[ContraBrokersGroup]):Option[List[ContraBrokersGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[ContraBrokersGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[ContraBrokersGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(ContraBrokersGroup(myFields.get(ContraBrokerField.TagId).flatMap(f=>ContraBrokerField.decode(f)),
          myFields.get(ContraTraderField.TagId).flatMap(f=>ContraTraderField.decode(f)),
          myFields.get(ContraTradeQtyField.TagId).flatMap(f=>ContraTradeQtyField.decode(f)),
          myFields.get(ContraTradeTimeField.TagId).flatMap(f=>ContraTradeTimeField.decode(f)),
          myFields.get(ContraLegRefIDField.TagId).flatMap(f=>ContraLegRefIDField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     