package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class LegsGroup(instrumentLegComponent:Option[InstrumentLegComponent]=None,
                     legSwapTypeField:Option[LegSwapTypeField]=None,
                     legSettlTypeField:Option[LegSettlTypeField]=None,
                     legStipulationsComponent:Option[LegStipulationsComponent]=None,
                     legBenchmarkCurveDataComponent:Option[LegBenchmarkCurveDataComponent]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    instrumentLegComponent.foreach(fmt(b,_))
    legSwapTypeField.foreach(fmt(b,_))
    legSettlTypeField.foreach(fmt(b,_))
    legStipulationsComponent.foreach(fmt(b,_))
    legBenchmarkCurveDataComponent.foreach(fmt(b,_))
    b
  }

}
     
object LegsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentLegComponent.isMandatoryField(tagId) || LegStipulationsComponent.isMandatoryField(tagId) || LegBenchmarkCurveDataComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    LegSwapTypeField.TagId, LegSettlTypeField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentLegComponent.isOptionalField(tagId) || LegStipulationsComponent.isOptionalField(tagId) || LegBenchmarkCurveDataComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentLegComponent.isFieldOf(tagId) || LegStipulationsComponent.isFieldOf(tagId) || LegBenchmarkCurveDataComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = InstrumentLegComponent.isFirstField(tagId) 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[LegsGroup]=ArrayBuffer.empty[LegsGroup]):Option[List[LegsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[LegsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[LegsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(LegsGroup(InstrumentLegComponent.decode(flds, startPos),
          myFields.get(LegSwapTypeField.TagId).flatMap(f=>LegSwapTypeField.decode(f)),
          myFields.get(LegSettlTypeField.TagId).flatMap(f=>LegSettlTypeField.decode(f)),
          LegStipulationsComponent.decode(flds, startPos),
          LegBenchmarkCurveDataComponent.decode(flds, startPos))))
      } else (startPos, None)
    }
  }
    
}
     